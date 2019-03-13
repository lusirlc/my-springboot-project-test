package pers.luchuan.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created By Lu Chuan On 2019/3/13
 */
@Aspect
@Component
public class AccessCountAspect {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
//	@Pointcut("execution(* pers.luchuan.test.controller.*.*(..)) && !execution(* pers.luchuan.test.controller.TestRedisController.getTotalAccessCount())")
	@Pointcut("@annotation(pers.luchuan.test.annotation.Statistics)")
	public void doPoint() {}
	
	@After("doPoint()")
	public void afterMethod(JoinPoint joinPoint){
		
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = servletRequestAttributes.getRequest();
		// 获取访问ip
		String ip = request.getRemoteAddr();
		
		String methodName = joinPoint.getSignature().getName();
		String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
		String prefix = declaringTypeName+"."+methodName;
		System.out.println(prefix);
		
		// 记录每个类的访问次数
		redisTemplate.opsForHash().increment("class_access_count",declaringTypeName, 1);
		// 记录每个方法的访问次数
		redisTemplate.opsForHash().increment("method_access_count",prefix, 1);
		// 记录整个网站的访问次数
		redisTemplate.opsForValue().increment("totalAccessCount", 1);
		// 记录访问网站的ip数
		redisTemplate.opsForSet().add("ip_access_count",ip);
	}
}
