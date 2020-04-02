package com.pablo.test;

import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.service.LtypeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:26
 * @package com.pablo.test
 * @characterization 设备大类别测试
 */
public class LtypeTest {
    private LtypeService ltypeService;
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(GlobalConfig.APPLICATION_CONFIG_XML);
        ltypeService = applicationContext.getBean(LtypeService.class);
    }

    @Test
    public void queryTest() {
        ltypeService.queryAll().forEach(v -> System.out.println("v = " + v));
    }
}
