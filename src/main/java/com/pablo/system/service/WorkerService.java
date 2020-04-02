package com.pablo.system.service;

import com.pablo.system.domain.WorkerVo;

import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/25 17:16
 * @package com.pablo.system.service
 * @characterization 工作人员事务层接口
 */
public interface WorkerService {
    int addWorker(WorkerVo workerVo);

    WorkerVo login(String username);

    int updateLoginDate(Map map);

    int insertLoginDate(String last_login);
}
