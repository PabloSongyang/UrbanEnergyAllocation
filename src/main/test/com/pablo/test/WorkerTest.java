package com.pablo.test;

import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.domain.WorkerVo;
import com.pablo.system.service.WorkerService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/25 18:37
 * @package com.pablo.test
 * @characterization 工作人员数据测试
 */
public class WorkerTest {
    private WorkerService workerService;
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(GlobalConfig.APPLICATION_CONFIG_XML);
        workerService = applicationContext.getBean(WorkerService.class);
    }

    @Test
    public void addWorkerTest() {
        System.out.println(workerService.addWorker(new WorkerVo("pablo", "123456")) != -1 ? "添加成功" : "返回失败");
    }

    @Test
    public void loginTest(){
        System.out.println(workerService.login("pablo"));
    }
}
