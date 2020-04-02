package com.pablo.test;

import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.service.CtypeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:52
 * @package com.pablo.test
 * @characterization 设备子类测试
 */
public class CtypeTest {
    private ApplicationContext applicationContext;
    private CtypeService ctypeService;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(GlobalConfig.APPLICATION_CONFIG_XML);
        ctypeService = applicationContext.getBean(CtypeService.class);
    }

    @Test
    public void queryAllTest() {
        ctypeService.queryAll().forEach(v -> System.out.println("v = " + v));
    }
}
