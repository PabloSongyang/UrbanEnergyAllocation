package com.pablo.system.service;

import com.pablo.system.domain.OperationMonitoringVo;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/1 15:40
 * @package com.pablo.system.service
 * @characterization 设备运行监测事务接口
 */
public interface OperationMonitoringService {
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
    int updateOperationMonitor(OperationMonitoringVo operationMonitoringVo) throws Exception;

    /**
     * 检索指定的设备信息
     * @return
     */
    OperationMonitoringVo queryEquipmentExisted(Map map);

    /**
     * 获取每个小时的所有已安装的设备的实际总功率
     * @return
     */
    Map<String,Object> getHourPower(String operate_date);
}
