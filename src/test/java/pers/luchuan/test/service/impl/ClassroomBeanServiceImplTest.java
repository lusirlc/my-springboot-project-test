package pers.luchuan.test.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pers.luchuan.test.dao.ClassroomBeanMapper;
import pers.luchuan.test.entity.ClassroomBean;

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
}