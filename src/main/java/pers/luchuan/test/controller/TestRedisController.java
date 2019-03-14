package pers.luchuan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.luchuan.test.annotation.Statistics;
import pers.luchuan.test.base.BaseResult;
import pers.luchuan.test.base.BaseResultGenerator;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created By Lu Chuan On 2019/3/13
 */
@RestController
@RequestMapping("/redis")
public class TestRedisController {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@GetMapping("/access_count")
	public BaseResult getTotalAccessCount() {
		Object totalAccessCount = redisTemplate.opsForValue().get("totalAccessCount");
		LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
		// 获取方法的访问次数
		Map methodMap = redisTemplate.opsForHash().entries("method_access_count");
		
		// 获取类的访问次数
		Map classMap = redisTemplate.opsForHash().entries("class_access_count");
		
		// 获取总访问量
		totalAccessCount = totalAccessCount == null ? 0 : totalAccessCount;
		// 获取ip数
		Long ipAccessCount = redisTemplate.opsForSet().size("ip_access_count");
		map.put("methodAccessCount", methodMap);
		map.put("classAccessCount", classMap);
		map.put("totalAccessCount", totalAccessCount);
		map.put("ipAccessCount", ipAccessCount);
		return BaseResultGenerator.success(map);
	}
	
	@Statistics
	@GetMapping("/method1")
	public String method1() {
		return "method1方法执行了";
	}
	
	@Statistics
	@GetMapping("/method2")
	public String method2() {
		return "method2方法执行了";
	}
	
	@Statistics
	@GetMapping("/method3")
	public String method3() {
		return "method3方法执行了";
	}
	
	@Statistics
	@GetMapping("/method4")
	public String method4() {
		return "method4方法执行了";
	}
}
