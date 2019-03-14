package pers.luchuan.test.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.luchuan.test.base.BaseResult;
import pers.luchuan.test.base.BaseResultGenerator;
import pers.luchuan.test.dao.ArticleMapper;
import pers.luchuan.test.entity.Article;

import java.util.*;

/**
 * Created By Lu Chuan On 2019/3/13
 */
@RestController
@RequestMapping("/article")
public class TestArticleController {
	
	@Autowired
	private RedisTemplate redisTemplate;
	
	@Autowired
	private ArticleMapper articleMapper;
	
	private static final String REDIS_ARTICLE = "ARTICLE_";
	private static final String REDIS_HOT_ARTICLE_RANK = "HOT_ARTICLE_RANK";
	
	// 读取某篇文章
	@GetMapping("/{id}")
	public BaseResult getArticle(@PathVariable("id") Integer id) {
		// 先从缓存中获取文章
		String key = REDIS_ARTICLE + id;
		Map articleMap = redisTemplate.opsForHash().entries(key);
		String msg = "从缓存中获取数据";
		// 缓存中没有从数据库查
		if (articleMap.size() == 0) {
			msg = "从数据库中获取数据";
			Article article = articleMapper.selectByPrimaryKey(id);
//			System.out.println(article);
			// 将article转为map，保留null值
			String jsonString = JSON.toJSONString(article, SerializerFeature.WriteMapNullValue);
//			System.out.println(jsonString);
			articleMap = JSON.parseObject(jsonString);
			// 查询结果放入缓存opsForHash，key为article_id，value为articleMap对象
			redisTemplate.opsForHash().putAll(key,articleMap);
		}
		// 更改文章的阅读数
		redisTemplate.opsForHash().increment(key, "hasViewed", 1);
		// 热门文章排行榜更新
		redisTemplate.opsForZSet().incrementScore(REDIS_HOT_ARTICLE_RANK, id, 1);
		// 返回的阅读数需要与数据库保持一致需+1
		Integer hasViewed = (Integer) articleMap.get("hasViewed");
		articleMap.put("hasViewed", hasViewed + 1);
		return BaseResultGenerator.success(msg,articleMap);
	}
	
	// 获取文章排行榜单
	@GetMapping("/hot_rank")
	public BaseResult getHotArticleRank() {
		// 获取榜单文章id
		Set<Integer> articleIdSet = redisTemplate.opsForZSet().reverseRange(REDIS_HOT_ARTICLE_RANK, 0, 10);
		List<Map<String, Object>> list = new ArrayList<>();
		for (Integer id : articleIdSet) {
			// 通过id获取文章信息，可先从缓存查
			Map articleMap = redisTemplate.opsForHash().entries(REDIS_ARTICLE + id);
			if (articleMap.size() == 0) {
				// 没有从数据库查
				Article article = articleMapper.selectByPrimaryKey(id);
				// 将article转为map
				articleMap = JSON.parseObject(JSON.toJSONString(article, SerializerFeature.WriteMapNullValue));
			}
			// 封装数据
			list.add(articleMap);
		}
		// 返回前端
		return BaseResultGenerator.success(list);
	}
	// 文章收藏功能
	// 文章点赞功能
}
