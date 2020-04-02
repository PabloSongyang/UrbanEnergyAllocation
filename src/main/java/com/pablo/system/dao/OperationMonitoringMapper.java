package com.pablo.system.dao;

import com.pablo.system.domain.OperationMonitoringVo;

import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/1 15:29
 * @package com.pablo.system.dao
 * @characterization 设备运行监测数据接口映射
 */
public interface OperationMonitoringMapper {
    /**
     * 插入监测记录
     * @param operationMonitoringVo
     * @return
     */
    int addOperationMonitor(OperationMonitoringVo operationMonitoringVo);

    /**
     * 更新实际功率
     * @return
     */
    int updateOperationMonitor(OperationMonitoringVo operationMonitoringVo);

    /**
     * 检索指定的设备信息
     * @return
     */
    OperationMonitoringVo queryEquipmentExisted(Map map);
}
