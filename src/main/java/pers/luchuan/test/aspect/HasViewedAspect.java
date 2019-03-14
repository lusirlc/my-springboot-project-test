package pers.luchuan.test.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created By Lu Chuan On 2019/3/13
 */
@Aspect
@Component
public class HasViewedAspect {
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Pointcut("@annotation(pers.luchuan.test.annotation.HasViewed)")
	public void doPoint() {}
	
	@After("doPoint()")
	public void afterMethod(JoinPoint joinPoint){
		Object[] args = joinPoint.getArgs();
		
	}
}
