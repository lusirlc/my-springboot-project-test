package pers.luchuan.test.annotation;

import java.lang.annotation.*;

/**
 * 要使用统计功能的方法或类采用该注解
 * Created By Lu Chuan On 2019/3/13
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Statistics {
}
