package pers.luchuan.test.service.impl;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pers.luchuan.test.config.RedisConfig;
import pers.luchuan.test.dao.ClassroomBeanMapper;
import pers.luchuan.test.entity.ClassroomBean;
import pers.luchuan.test.exception.BusinessException;
import pers.luchuan.test.service.ClassroomBeanService;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lu Chuan on 2019/3/2
 */
@Service
@Slf4j
public class ClassroomBeanServiceImpl implements ClassroomBeanService {
    @Autowired
    private ClassroomBeanMapper classroomBeanMapper;
    
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Autowired
    private RedisTemplate redisTemplate;
    
    public static final String REDIS_CLASSROOM_LIST = "REDIS_CLASSROOM_LIST";
    
    

//    @Transactional(propagation = Propagation.SUPPORTS)
//    @Transactional(propagation = Propagation.REQUIRED)
//    @Transactional(propagation = Propagation.MANDATORY)
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    @Transactional(propagation = Propagation.NEVER)
//    @Transactional(propagation = Propagation.NESTED)
//    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Transactional
    @Override
    public void addClassroom(ClassroomBean classroomBean) {
        String method = "【添加教室】";
        classroomBeanMapper.insertSelective(classroomBean);
    
        try {
            int i = 1/0;
        } catch (Exception e) {
            log.error(method+"运算错误：{}",e);
            throw new BusinessException(10001,"运算错误");
        }
    }
    
    public List<ClassroomBean> getClassroomList(){
        String result = stringRedisTemplate.opsForValue().get(REDIS_CLASSROOM_LIST);
//        stringRedisTemplate.opsForHash().
        if (result == null) {
            System.out.println("从数据库中获取数据");
            List<ClassroomBean> list = classroomBeanMapper.selectAll();
            stringRedisTemplate.opsForValue().set(REDIS_CLASSROOM_LIST, JSON.toJSONString(list), 20L, TimeUnit.SECONDS);
            return list;
        } else {
            System.out.println("从缓存中获取数据");
            return JSON.parseArray(result,ClassroomBean.class);
        }
    }

}
