package pers.luchuan.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.luchuan.test.dao.ClassroomBeanMapper;
import pers.luchuan.test.entity.ClassroomBean;
import pers.luchuan.test.service.ClassroomBeanService;

/**
 * Created by Lu Chuan on 2019/3/2
 */
@Service
public class ClassroomBeanServiceImpl implements ClassroomBeanService {
    @Autowired
    private ClassroomBeanMapper classroomBeanMapper;

//    @Transactional(propagation = Propagation.SUPPORTS)
//    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.NEVER)
    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addClassroom(ClassroomBean classroomBean) {
        classroomBeanMapper.insertSelective(classroomBean);
        int i = 1/0;
    }

}
