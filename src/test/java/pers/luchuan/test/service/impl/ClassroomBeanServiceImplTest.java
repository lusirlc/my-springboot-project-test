package pers.luchuan.test.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.luchuan.test.dao.ArticleMapper;
import pers.luchuan.test.dao.ClassroomBeanMapper;
import pers.luchuan.test.entity.Article;
import pers.luchuan.test.entity.ClassroomBean;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Lu Chuan on 2019/3/3
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassroomBeanServiceImplTest {

    @Autowired
    private ClassroomBeanServiceImpl service;

    @Autowired
    private ClassroomBeanMapper mapper;
    
    @Autowired
    private ArticleMapper articleMapper;
    
    @Test
    public void addClassroom() {
        ClassroomBean classroomBean = new ClassroomBean();
        classroomBean.setId(1005);
        classroomBean.setName("高一5班");
        service.addClassroom(classroomBean);
    }

    @Test
    public void testUpdate(){
        ClassroomBean classroomBean = new ClassroomBean();
        classroomBean.setId(1005);
        classroomBean.setName("高一5班");
        mapper.updateByPrimaryKeySelective(classroomBean);
    }
    
    @Test
    public void testCache() {
        List<ClassroomBean> classroomList = service.getClassroomList();
        System.out.println(classroomList);
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
        for (Article article : articleList) {
            articleMapper.insert(article);
        }
    }
}