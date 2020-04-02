package com.pablo.test;

import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.domain.OperationMonitoringVo;
import com.pablo.system.service.OperationMonitoringService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/2 0:51
 * @package com.pablo.test
 * @characterization 设备运行监测测试
 */
public class OperationMonitoringTest {
    private OperationMonitoringService operationMonitoringService;
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(GlobalConfig.APPLICATION_CONFIG_XML);
        operationMonitoringService = applicationContext.getBean(OperationMonitoringService.class);
    }

    @Test
    public void updateTest() throws Exception {
        OperationMonitoringVo operationMonitoringVo = new OperationMonitoringVo();
        operationMonitoringVo.setEid(6);
        operationMonitoringVo.setFifteen_hour(500d);

        System.out.println(operationMonitoringService.updateOperationMonitor(operationMonitoringVo) != -1 ? "更新成功" : "更新失败");
    }
}
