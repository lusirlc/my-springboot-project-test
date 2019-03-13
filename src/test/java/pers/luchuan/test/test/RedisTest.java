package pers.luchuan.test.test;

import com.alibaba.fastjson.JSON;
import org.assertj.core.util.Sets;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.junit4.SpringRunner;
import pers.luchuan.test.entity.StudentBean;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Created By Lu Chuan On 2019/3/12
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisTest {
	
	@Autowired
	private StringRedisTemplate template;
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Test
	public void testString() {
//	    template.opsForValue().set("name", "张三",30, TimeUnit.SECONDS);
//		String name = template.opsForValue().get("name");
//		System.out.println(name);
//		template.opsForValue().set("key","Hello Java");
//		template.opsForValue().set("key","World",6);
//		System.out.println(template.opsForValue().get("key"));
//		System.out.println(template.opsForValue().setIfAbsent("key", "Hello"));
//		System.out.println(template.opsForValue().setIfAbsent("name", "张三"));
//		HashMap<String, String> map = new HashMap<>();
//		map.put("name", "张三");
//		map.put("age", "18");
//		template.opsForValue().multiSet(map);
//		List<String> list = Arrays.asList("name", "age");
//		System.out.println(template.opsForValue().multiGet(list));
//		map.put("gender", "男");
//		map.put("job", "老师");
//		System.out.println(template.opsForValue().multiSetIfAbsent(map));
//		System.out.println(template.opsForValue().getAndSet("test", "test"));
//		template.opsForValue().increment("count", 1);
//		template.opsForValue().increment("count_2", 1.2);
//		System.out.println(template.opsForValue().append("append", "append"));
		System.out.println(template.opsForValue().get("name", 0, 2));
//		System.out.println(template.opsForValue().size("append"));
		
	}
	
	@Test
	public void testList() {
//		template.opsForList().rightPush("list", "java");
//		template.opsForList().rightPush("list", "c");
//		template.opsForList().rightPush("list", "php");
		String[] strings = new String[]{"1","2","3"};
		template.opsForList().rightPushAll("list", strings);
//		System.out.println(template.opsForList().rightPush("list", "python"));
//		System.out.println(template.opsForList().range("list", 0, -1));
//		template.opsForList().trim("list",1,-2);
//		template.opsForList().rightPushIfPresent("ll", "111");
//		template.opsForList().rightPush("list", "c", "d");
//		template.opsForList().set("list",1,"b");
//		System.out.println(template.opsForList().remove("list", 0, "b"));
//		System.out.println(template.opsForList().index("list", 1));
//		System.out.println(template.opsForList().rightPop("list"));
//		while (true) {
//			System.out.println(template.opsForList().rightPop("list", 10, TimeUnit.SECONDS));
//		}
//		while (true) {
//			System.out.println(template.opsForList().rightPopAndLeftPush("list", "list1", 3, TimeUnit.SECONDS));
//		}
	}
	
	@Test
	public void testHash() {
//	    template.opsForHash().put("map","name","Tom");
//		template.opsForHash().put("map","age","18");
//		template.opsForHash().put("map","gender","male");
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("name", "Tom");
//		map.put("age", 18);
//		map.put("gender", "male");
//		redisTemplate.opsForHash().putAll("map",map);
//		System.out.println(redisTemplate.opsForHash().delete("map", "gender"));
//		System.out.println(redisTemplate.opsForHash().hasKey("map", "gender"));
//		System.out.println(redisTemplate.opsForHash().get("map", "name"));
//		List<String> strings = Arrays.asList("name", "age");
//		System.out.println(redisTemplate.opsForHash().multiGet("map", strings));
//		System.out.println(redisTemplate.opsForHash().increment("map", "age", -1));
//		System.out.println(redisTemplate.opsForHash().keys("map"));
//		System.out.println(redisTemplate.opsForHash().size("map"));
//		System.out.println(redisTemplate.opsForHash().entries("map"));
//		redisTemplate.opsForHash().put("map","age",18);
//		System.out.println(redisTemplate.opsForHash().putIfAbsent("map", "age", 19));
//		System.out.println(redisTemplate.opsForHash().values("map"));
//		Cursor<Map.Entry<Object,Object>> cursor = redisTemplate.opsForHash().scan("map", ScanOptions.NONE);
//		while (cursor.hasNext()) {
//			Map.Entry<Object, Object> next = cursor.next();
//			System.out.println(next.getKey() + ":" + next.getValue());
//		}
	
	}
	
	@Test
	public void testSet() {
//		System.out.println(redisTemplate.opsForSet().add("set", 1, "str", new Date()));
//		System.out.println(redisTemplate.opsForSet().remove("set", 1, "str"));
//		System.out.println(redisTemplate.opsForSet().pop("set"));
//		System.out.println(redisTemplate.opsForSet().move("set", "str", "set1"));
//		System.out.println(redisTemplate.opsForSet().size("set"));
//		System.out.println(redisTemplate.opsForSet().isMember("set", 1));
//		System.out.println(redisTemplate.opsForSet().intersect("set", "set1"));
		List<String> list = Arrays.asList("set1", "set2");
//		System.out.println(redisTemplate.opsForSet().intersect("set", list));
//		System.out.println(redisTemplate.opsForSet().intersectAndStore("set", "set1", "set4"));
//		System.out.println(redisTemplate.opsForSet().intersectAndStore("set", list, "set5"));
//		System.out.println(redisTemplate.opsForSet().union("set", "set1"));
//		System.out.println(redisTemplate.opsForSet().union("set", list));
//		System.out.println(redisTemplate.opsForSet().unionAndStore("set", "set1", "set5"));
//		System.out.println(redisTemplate.opsForSet().difference("set1", "set"));
//		System.out.println(redisTemplate.opsForSet().difference("set", list));
//		System.out.println(redisTemplate.opsForSet().differenceAndStore("set", "set1", "set5"));
//		System.out.println(redi	sTemplate.opsForSet().distinctRandomMembers("set", 2));
		Cursor<Object> cursor = redisTemplate.opsForSet().scan("set", ScanOptions.NONE);
		while (cursor.hasNext()) {
			Object next = cursor.next();
			System.out.println(next);
			
		}
	}
	
	@Test
	public void testZSet() {
//		System.out.println(redisTemplate.opsForZSet().add("zset", 2, 10));
//		DefaultTypedTuple<Object> tuple1 = new DefaultTypedTuple<Object>("value1",10.0);
//		DefaultTypedTuple<Object> tuple2 = new DefaultTypedTuple<Object>("value2",20.0);
//		HashSet<ZSetOperations.TypedTuple<Object>> tuples = new HashSet<>();
//		tuples.add(tuple1);
//		tuples.add(tuple2);
//		System.out.println(redisTemplate.opsForZSet().add("zset1", tuples));
//		System.out.println(redisTemplate.opsForZSet().remove("zset", 2, "value"));
//		System.out.println(redisTemplate.opsForZSet().incrementScore("zset", "value", 1.0));
//		System.out.println(redisTemplate.opsForZSet().rank("zset", "value1"));
//		System.out.println(redisTemplate.opsForZSet().reverseRank("zset", "value"));
//		System.out.println(redisTemplate.opsForZSet().range("zset", 0, -1));
//		System.out.println(redisTemplate.opsForZSet().reverseRange("zset", 0, -1));
//		Set<ZSetOperations.TypedTuple<Object>> tuples = redisTemplate.opsForZSet().reverseRangeWithScores("zset", 0, -1);
//		Iterator<ZSetOperations.TypedTuple<Object>> iterator = tuples.iterator();
//		while (iterator.hasNext()) {
//			ZSetOperations.TypedTuple<Object> tuple = iterator.next();
//			System.out.println(tuple.getValue()+":"+tuple.getScore());
//		}
//		System.out.println(redisTemplate.opsForZSet().rangeByScore("zset", 0, 20.0));
//		System.out.println(redisTemplate.opsForZSet().reverseRangeByScore("zset", 0, 20.0));
//		Set<ZSetOperations.TypedTuple<Object>> tuples = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("zset", 0, 20.0);
//		Iterator<ZSetOperations.TypedTuple<Object>> iterator = tuples.iterator();
//		while (iterator.hasNext()) {
//			ZSetOperations.TypedTuple<Object> next = iterator.next();
//			System.out.println(next.getValue() + ":" + next.getScore());
//		}
//		System.out.println(redisTemplate.opsForZSet().rangeByScore("zset", 0, 20, 1, 1));
//		System.out.println(redisTemplate.opsForZSet().reverseRangeByScore("zset", 0, 20, 0, 2));
//		Set<ZSetOperations.TypedTuple<Object>> tuples = redisTemplate.opsForZSet().reverseRangeByScoreWithScores("zset", 0, 20, 0, 2);
//		Iterator<ZSetOperations.TypedTuple<Object>> iterator = tuples.iterator();
//		while (iterator.hasNext()) {
//			ZSetOperations.TypedTuple<Object> next = iterator.next();
//			System.out.println(next.getValue() + ":" + next.getScore());
//		}
//		System.out.println(redisTemplate.opsForZSet().count("zset", 0, 20));
//		System.out.println(redisTemplate.opsForZSet().size("zset"));
//		System.out.println(redisTemplate.opsForZSet().zCard("zset"));
//		System.out.println(redisTemplate.opsForZSet().score("zset", "value"));
//		System.out.println(redisTemplate.opsForZSet().removeRange("zset", 0, 1));
//		System.out.println(redisTemplate.opsForZSet().removeRangeByScore("zset", 10, 20));
//		System.out.println(redisTemplate.opsForZSet().unionAndStore("zset", "zset1", "destZset"));
		List<String> list = Arrays.asList("zset", "zset1");
		System.out.println(redisTemplate.opsForZSet().unionAndStore("zset", list, "destZset"));
	}
	
	@Test
	public void testSerializer() {
//		StudentBean studentBean = new StudentBean();
//		studentBean.setName("张三");
//		studentBean.setAge((byte) 18);
//		List<StudentBean> list = Arrays.asList(studentBean);
//		redisTemplate.opsForValue().set("studentList",list);
//		List<StudentBean> studentList = (List<StudentBean>) redisTemplate.opsForValue().get("studentList");
//		System.out.println(studentList);
	}
}
