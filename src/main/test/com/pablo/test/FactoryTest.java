package com.pablo.test;

import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.service.FactoryService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:43
 * @package com.pablo.test
 * @characterization 生产厂家测试
 */
public class FactoryTest {
    private FactoryService factoryService;
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(GlobalConfig.APPLICATION_CONFIG_XML);
        factoryService = applicationContext.getBean(FactoryService.class);
    }

    @Test
    public void queryAllTest() {
        factoryService.queryAll().forEach(v -> System.out.println("v = " + v));
    }
}
