package com.pablo.system.dao;

import com.pablo.system.domain.WorkerVo;

import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/25 17:15
 * @package com.pablo.system.domain
 * @characterization 工作人员数据接口映射
 */
public interface WorkerMapper {
    /**
     * 添加工人
     * @param workerVo
     * @return
     */
    int addWorker(WorkerVo workerVo);

    /**
     * 登录检测
     * @param username
     * @return
     */
    WorkerVo login(String username);

    /**
     * 更新登录时间
     * @param map
     * @return
     */
    int updateLoginDate(Map map);

    /**
     * 插入登录时间
     * @param last_login
     * @return
     */
    int insertLoginDate(String last_login);
}
