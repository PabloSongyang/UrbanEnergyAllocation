package com.pablo.system.service.impl;

import com.pablo.system.dao.OperationMonitoringMapper;
import com.pablo.system.domain.OperationMonitoringVo;
import com.pablo.system.service.OperationMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
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

        int curHour = Integer.parseInt(new SimpleDateFormat("HH").format(System.currentTimeMillis()));
        OperationMonitoringVo monitoringVo = new OperationMonitoringVo();
        monitoringVo.setEid(operationMonitoringVo.getEid());
        monitoringVo.setOperate_date(operationMonitoringVo.getOperate_date());

        switch (curHour){
            case 0:
                monitoringVo.setZero_hour(operationMonitoringVo.getZero_hour());
                break;
            case 1:
                monitoringVo.setOne_hour(operationMonitoringVo.getOne_hour());
                break;
            case 2:
                monitoringVo.setTwo_hour(operationMonitoringVo.getTwo_hour());
                break;
            case 3:
                monitoringVo.setThree_hour(operationMonitoringVo.getThree_hour());
                break;
            case 4:
                monitoringVo.setFour_hour(operationMonitoringVo.getFour_hour());
                break;
            case 5:
                monitoringVo.setFive_hour(operationMonitoringVo.getFive_hour());
                break;
            case 6:
                monitoringVo.setSix_hour(operationMonitoringVo.getSix_hour());
                break;
            case 7:
                monitoringVo.setSeven_hour(operationMonitoringVo.getSeven_hour());
                break;
            case 8:
                monitoringVo.setEight_hour(operationMonitoringVo.getEight_hour());
                break;
            case 9:
                monitoringVo.setNine_hour(operationMonitoringVo.getNine_hour());
                break;
            case 10:
                monitoringVo.setTen_hour(operationMonitoringVo.getTen_hour());
                break;
            case 11:
                monitoringVo.setEleven_hour(operationMonitoringVo.getEleven_hour());
                break;
            case 12:
                monitoringVo.setTwelve_hour(operationMonitoringVo.getTwelve_hour());
                break;
            case 13:
                monitoringVo.setThirteen_hour(operationMonitoringVo.getThirteen_hour());
                break;
            case 14:
                monitoringVo.setFourteen_hour(operationMonitoringVo.getFourteen_hour());
                break;
            case 15:
                monitoringVo.setFifteen_hour(operationMonitoringVo.getFifteen_hour());
                break;
            case 16:
                monitoringVo.setSixteen_hour(operationMonitoringVo.getSixteen_hour());
                break;
            case 17:
                monitoringVo.setSeventeen_hour(operationMonitoringVo.getSeventeen_hour());
                break;
            case 18:
                monitoringVo.setEighteen_hour(operationMonitoringVo.getEighteen_hour());
                break;
            case 19:
                monitoringVo.setNineteen_hour(operationMonitoringVo.getNineteen_hour());
                break;
            case 20:
                monitoringVo.setTwenty_hour(operationMonitoringVo.getTen_hour());
                break;
            case 21:
                monitoringVo.setTwentyone_hour(operationMonitoringVo.getTwentyone_hour());
                break;
            case 22:
                monitoringVo.setTwentytwo_hour(operationMonitoringVo.getTwentytwo_hour());
                break;
            case 23:
                monitoringVo.setTwentythree_hour(operationMonitoringVo.getTwentythree_hour());
                break;
        }

        if (vo != null)
            if (operationMonitoringMapper.updateOperationMonitor(monitoringVo) > 0)
                result = 1;
            else
                throw new Exception();
        else if (operationMonitoringMapper.addOperationMonitor(monitoringVo) > 0)
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

    @Override
    @Transactional(readOnly = true)
    public Map<String, Object> getHourPower(String operate_date) {
        return operationMonitoringMapper.getHourPower(operate_date);
    }
}
