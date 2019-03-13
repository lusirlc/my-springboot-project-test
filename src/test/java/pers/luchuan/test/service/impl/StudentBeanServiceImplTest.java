package pers.luchuan.test.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.luchuan.test.entity.StudentBean;

/**
 * Created by Lu Chuan on 2019/3/3
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentBeanServiceImplTest {

    @Autowired
    StudentBeanServiceImpl service;

    @Test
    public void addStudent() {
        StudentBean studentBean = new StudentBean();
        studentBean.setId(20130625);
        studentBean.setName("张三");
        service.addStudent(studentBean);
    }
}