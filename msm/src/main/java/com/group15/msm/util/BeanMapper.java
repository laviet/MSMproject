package com.group15.msm.util;

import org.dozer.DozerBeanMapper;

/**
 * @author: laviet
 * Version: 1.0
 * Create date: 20-11-2019
 * Time: 21:51
 */
public class BeanMapper {
    //coppy bean
    public static void BeanCoppy(Object source, Object destination) {
        DozerBeanMapper beanMapper=new DozerBeanMapper();
        beanMapper.map(source, destination);
    }
}
