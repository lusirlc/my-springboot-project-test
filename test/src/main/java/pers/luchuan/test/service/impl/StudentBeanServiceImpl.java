package pers.luchuan.test.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.luchuan.test.dao.ClassroomBeanMapper;
import pers.luchuan.test.dao.StudentBeanMapper;
import pers.luchuan.test.entity.ClassroomBean;
import pers.luchuan.test.entity.StudentBean;
import pers.luchuan.test.service.ClassroomBeanService;
import pers.luchuan.test.service.StudentBeanService;

@Service
public class StudentBeanServiceImpl implements StudentBeanService{

    @Autowired
    private StudentBeanMapper studentBeanMapper;

    @Autowired
    private ClassroomBeanServiceImpl classroomBeanService;

    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(propagation = Propagation.SUPPORTS)
//    @Transactional(propagation = Propagation.MANDATORY)
    public void addStudent(StudentBean studentBean) {
        studentBeanMapper.insertSelective(studentBean);
        ClassroomBean classroomBean = new ClassroomBean();
        classroomBean.setId(1005);
        classroomBean.setName("高一5班");
        try {
            classroomBeanService.addClassroom(classroomBean);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        int i = 1/0;
    }
}
