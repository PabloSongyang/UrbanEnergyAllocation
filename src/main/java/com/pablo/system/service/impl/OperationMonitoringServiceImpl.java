package com.pablo.system.service.impl;

import com.pablo.system.dao.OperationMonitoringMapper;
import com.pablo.system.domain.OperationMonitoringVo;
import com.pablo.system.service.OperationMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/1 15:40
 * @package com.pablo.system.service.impl
 * @characterization 设备运行监测事务接口实现
 */
@Service
public class OperationMonitoringServiceImpl implements OperationMonitoringService {
    @Autowired
    private OperationMonitoringMapper operationMonitoringMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int addOperationMonitor(OperationMonitoringVo operationMonitoringVo) {
        return operationMonitoringMapper.addOperationMonitor(operationMonitoringVo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int updateOperationMonitor(OperationMonitoringVo operationMonitoringVo) throws Exception {
        int result = -1;
        Map<String, Object> map = new HashMap<>();
        map.put("eid", operationMonitoringVo.getEid());
        map.put("operate_date", operationMonitoringVo.getOperate_date());
        OperationMonitoringVo vo = operationMonitoringMapper.queryEquipmentExisted(map);
        if (vo != null)
            if (operationMonitoringMapper.updateOperationMonitor(operationMonitoringVo) > 0)
                result = 1;
            else
                throw new Exception();
        else if (operationMonitoringMapper.addOperationMonitor(operationMonitoringVo) > 0)
            result = 1;
        else
            throw new Exception();

        return result;
    }

    @Override
    @Transactional(readOnly = true)
    public OperationMonitoringVo queryEquipmentExisted(Map map) {
        return operationMonitoringMapper.queryEquipmentExisted(map);
    }
}
