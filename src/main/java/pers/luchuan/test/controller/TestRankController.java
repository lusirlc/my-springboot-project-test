package pers.luchuan.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.DefaultTypedTuple;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.luchuan.test.base.BaseResult;
import pers.luchuan.test.base.BaseResultGenerator;
import pers.luchuan.test.dao.ArticleMapper;
import pers.luchuan.test.entity.Article;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * Created By Lu Chuan On 2019/3/13
 */
@RestController
@RequestMapping("/rank")
public class TestRankController {
	@Autowired
	private RedisTemplate redisTemplate;
	@Autowired
	private ArticleMapper articleMapper;
	
	/**
	 * 获取文章排行榜信息
	 * @return
	 */
	@GetMapping("/article")
	public BaseResult getArticleRank(){
		// 先从缓存中获取
		Set hotArticle = redisTemplate.opsForZSet().reverseRange("hot_article", 0, -1);
		if (hotArticle.size() == 0) {
			// 缓存没有查询数据库获取然后存入到缓存
			Example example = new Example(Article.class);
			example.orderBy("hasViewed").desc();
			List<Article> articleList = articleMapper.selectByExample(example);
			// 将查询的结果放入tuples
			HashSet<ZSetOperations.TypedTuple<Article>> tuples = new HashSet<>();
			for (Article article : articleList) {
				DefaultTypedTuple<Article> tuple = new DefaultTypedTuple<Article>(article, article.getHasViewed() == null ? 0 : article.getHasViewed().doubleValue());
				tuples.add(tuple);
			}
			// 存入缓存
			redisTemplate.opsForZSet().add("hot_article", tuples);
			return BaseResultGenerator.success("从数据库中获取数据",articleList);
		}
		return BaseResultGenerator.success("从缓存中获取数据", hotArticle);
		
	}
	
}
