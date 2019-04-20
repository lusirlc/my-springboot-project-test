package pers.luchuan.test.test;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import pers.luchuan.test.dao.ArticleMapper;
import pers.luchuan.test.entity.Article;
import pers.luchuan.test.entity.Father;
import pers.luchuan.test.entity.GrandSon;
import pers.luchuan.test.entity.Son;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Lu Chuan on 2019/3/4
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TempTest {
	@Autowired
	private ArticleMapper articleMapper;
	
	@Test
	public void testString() {
		String str = "111" + null;
		System.out.println(str); // 结果：111null
	}
	
	@Test
	@Transactional
	public void testTryCatch() {
		System.out.println("111");
		try {
			int i = 1 / 0;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("222");
	}
	
	@Test
	public void testInsertArticle() {
		Article article1 = new Article();
		article1.setTitle("article1");
		article1.setHasViewed(1);
		Article article2 = new Article();
		article2.setTitle("article2");
		article2.setHasViewed(2);
		Article article3 = new Article();
		article3.setTitle("article3");
		article3.setHasViewed(3);
		Article article4 = new Article();
		article4.setTitle("article4");
		article4.setHasViewed(4);
		Article article5 = new Article();
		article5.setTitle("article5");
		article5.setHasViewed(5);
		Article article6 = new Article();
		article6.setTitle("article6");
		article6.setHasViewed(6);
		Article article7 = new Article();
		article7.setTitle("article7");
		article7.setHasViewed(7);
		Article article8 = new Article();
		article8.setTitle("article8");
		article8.setHasViewed(8);
		Article article9 = new Article();
		article9.setTitle("article9");
		article9.setHasViewed(9);
		List<Article> articleList = Arrays.asList(article1, article2, article3, article4, article5, article6, article7, article8, article9);
		articleMapper.insertList(articleList);
	}
	
	
	@Test
	public void testJsonToString() {
		Article article = new Article();
		article.setId(1);
		article.setTitle("111");
		String s = JSON.toJSONString(article);
		System.out.println(s);
		Article a = JSON.parseObject(s, Article.class);
		System.out.println(a);
	}

	@Test
	public void testPolymorphism() {
		Father father = new Father();
		Father fSon = new Son();
		Son son = new Son();
		Father fGrandSon = new GrandSon();
		Son sGrandson = new GrandSon();
		GrandSon grandSon = new GrandSon();
		father.fatherField = "father";
		father.fatherMethod();
		fSon.fatherField = "fSon";
		fSon.fatherMethod();
		son.fatherField = "son";
		son.sonField = "son";
		son.fatherMethod();
		son.sonMethod();
		sGrandson.fatherField = "sGrandSon";
		sGrandson.sonField = "sGrandSon";
		sGrandson.fatherMethod();
		sGrandson.sonMethod();
	}
}
