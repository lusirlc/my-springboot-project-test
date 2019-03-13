package pers.luchuan.test.handler;

import com.google.common.collect.ImmutableMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pers.luchuan.test.base.BaseResult;
import pers.luchuan.test.base.BaseResultGenerator;
import pers.luchuan.test.enums.BaseResultEnum;
import pers.luchuan.test.exception.BusinessException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * Created By Chuan Lu On 2019/2/28 12:52
 */
@Slf4j
@RestControllerAdvice
public class MyExceptionHandler {
	//使用EXCEPTIONS存放异常类型和错误代码的映射，ImmutableMap的特点的一旦创建不可改变，并且线程安全
	private static ImmutableMap<Class<? extends Throwable>, BaseResultEnum> EXCEPTIONS;
	
	//使用builder来构建一个异常类型和错误代码的异常
	protected static ImmutableMap.Builder<Class<? extends Throwable>, BaseResultEnum> builder = ImmutableMap.builder();
	
	/**
	 * 捕获Exception异常
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public BaseResult handleException(Exception e) {
		log.error("catch exception:{}\r\nexception:{} ", e.getMessage(), e);
		if (EXCEPTIONS == null)
			EXCEPTIONS = builder.build();
		final BaseResultEnum BaseResultEnum = EXCEPTIONS.get(e.getClass());
		final BaseResult BaseResult;
		if (BaseResultEnum != null) {
			BaseResult = new BaseResult();
			BaseResult.setCode(BaseResultEnum.getCode());
			BaseResult.setMessage(BaseResultEnum.getMessage());
		} else {
			BaseResult = BaseResultGenerator.error(BaseResultEnum.SERVER_ERROR);
		}
		return BaseResult;
	}
	
	/**
	 * 捕获业务异常
	 * @param exception
	 * @return
	 */
	@ExceptionHandler(BusinessException.class)//可以直接写@ExceptionHandler,不指明异常类，会自动映射
	public BaseResult handleBusinessException(BusinessException exception) { //还可以声明接收其他任意参数
		return BaseResultGenerator.error(exception.getErrorCode(),exception.getErrorMessage());
	}
	
	/**
	 * 字段校验
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public BaseResult handleValidationException(ConstraintViolationException ex){
		StringBuilder msgBuilder = new StringBuilder();
		StringBuilder messageBuilder = new StringBuilder();
		Set<ConstraintViolation<?>> constraintViolations = ex.getConstraintViolations();
		if (!CollectionUtils.isEmpty(constraintViolations)) {
			for(ConstraintViolation<?> s: constraintViolations){
				messageBuilder.append(s.getPropertyPath()+": "+s.getMessage()+",");
				msgBuilder.append(s.getMessage()+",");
			}
			String errorMessage = msgBuilder.toString();
			String message = messageBuilder.toString();
			if (errorMessage.length() > 1) {
				errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
			}
			if (message.length() > 1) {
				message = message.substring(0, message.length() - 1);
			}
			log.info("请求参数不合法 -> {}", message);
			return BaseResultGenerator.error(errorMessage);
		}
		return BaseResultGenerator.error();
	}
	
	/**
	 * Bean校验
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(BindException.class)
	public BaseResult handleBindException(BindException ex) {
		String errorMessage = null;
		List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
		if (!CollectionUtils.isEmpty(objectErrors)) {
			StringBuilder msgBuilder = new StringBuilder();
			String paramName = objectErrors.get(0).getObjectName();
			for (ObjectError objectError : objectErrors) {
				msgBuilder.append(objectError.getDefaultMessage()).append(",");
			}
			errorMessage = msgBuilder.toString();
			if (errorMessage.length() > 1) {
				errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
			}
			log.info("请求参数不合法 -> {}",paramName + ":" + errorMessage);
			return BaseResultGenerator.error(errorMessage);
		}
		return BaseResultGenerator.error();
	}
}
