package com.pablo.test;

import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.service.EtypeService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 16:03
 * @package com.pablo.test
 * @characterization 能源类别测试类
 */
public class EtypeTest {
    private EtypeService etypeService;
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(GlobalConfig.APPLICATION_CONFIG_XML);
        etypeService = applicationContext.getBean(EtypeService.class);
    }

    @Test
    public void queryAllTest() {
        etypeService.queryAll().forEach(v -> System.out.println("v = " + v));
    }
}
