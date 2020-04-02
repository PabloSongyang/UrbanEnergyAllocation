package com.pablo.system.service.impl;

import com.pablo.system.dao.EquipmentMapper;
import com.pablo.system.dao.InstallMapper;
import com.pablo.system.dao.OperationMonitoringMapper;
import com.pablo.system.domain.InstallVo;
import com.pablo.system.domain.OperationMonitoringVo;
import com.pablo.system.service.InstallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 16:32
 * @package com.pablo.system.service.impl
 * @characterization 安装设备事务层接口实现
 */
@Service
public class InstallServiceImpl implements InstallService {
    @Autowired
    private InstallMapper installMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private OperationMonitoringMapper operationMonitoringMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int installEquipment(InstallVo installVo, Map map) throws Exception {
        int result = -1;

        int insertResult = installMapper.installEquipment(installVo);
        if (insertResult > 0) {
            int updateResult = equipmentMapper.updateEquipmentStatus(map);
            if (updateResult > 0) {
                OperationMonitoringVo operationMonitoringVo = new OperationMonitoringVo();
                operationMonitoringVo.setEid(installVo.getEid());
                operationMonitoringVo.setOperate_date(installVo.getInstall_time().split(" ")[0]);
                int hour = Integer.parseInt((installVo.getInstall_time().split(" ")[1]).split(":")[0]);
                switch (hour) {
                    case 0:
                        operationMonitoringVo.setZero_hour(400.0);
                        break;
                    case 1:
                        operationMonitoringVo.setOne_hour(400.0);
                        break;
                    case 2:
                        operationMonitoringVo.setTwo_hour(400.0);
                        break;
                    case 3:
                        operationMonitoringVo.setThree_hour(400.0);
                        break;
                    case 4:
                        operationMonitoringVo.setFour_hour(400.0);
                        break;
                    case 5:
                        operationMonitoringVo.setFive_hour(400.0);
                        break;
                    case 6:
                        operationMonitoringVo.setSix_hour(400.0);
                        break;
                    case 7:
                        operationMonitoringVo.setSeven_hour(400.0);
                        break;
                    case 8:
                        operationMonitoringVo.setEight_hour(400.0);
                        break;
                    case 9:
                        operationMonitoringVo.setNine_hour(400.0);
                        break;
                    case 10:
                        operationMonitoringVo.setTen_hour(400.0);
                        break;
                    case 11:
                        operationMonitoringVo.setEleven_hour(400.0);
                        break;
                    case 12:
                        operationMonitoringVo.setTwelve_hour(400.0);
                        break;
                    case 13:
                        operationMonitoringVo.setThirteen_hour(400.0);
                        break;
                    case 14:
                        operationMonitoringVo.setFourteen_hour(400.0);
                        break;
                    case 15:
                        operationMonitoringVo.setFifteen_hour(400.0);
                        break;
                    case 16:
                        operationMonitoringVo.setSixteen_hour(400.0);
                        break;
                    case 17:
                        operationMonitoringVo.setSeventeen_hour(400.0);
                        break;
                    case 18:
                        operationMonitoringVo.setEighteen_hour(400.0);
                        break;
                    case 19:
                        operationMonitoringVo.setNineteen_hour(400.0);
                        break;
                    case 20:
                        operationMonitoringVo.setTwenty_hour(400.0);
                        break;
                    case 21:
                        operationMonitoringVo.setTwentyone_hour(400.0);
                        break;
                    case 22:
                        operationMonitoringVo.setTwentytwo_hour(400.0);
                        break;
                    case 23:
                        operationMonitoringVo.setTwentythree_hour(400.0);
                        break;
                }

                if (operationMonitoringMapper.addOperationMonitor(operationMonitoringVo) > 0)
                    result = 1;
            } else
                throw new Exception();
        } else
            throw new Exception();

        return result;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int deleteInstallNoteByEid(Integer eid) {
        return installMapper.deleteInstallNoteByEid(eid);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> showInstalledList(Map map) {
        return installMapper.showInstalledList(map);
    }

    @Override
    @Transactional(readOnly = true)
    public int getRecordCount() {
        return installMapper.getRecordCount();
    }

    @Override
    @Transactional(readOnly = true)
    public InstallVo queryInstallNoteByEid(Integer eid) {
        return installMapper.queryInstallNoteByEid(eid);
    }

    @Override
    public List<Map<String, Object>> realTimeMonitoring() {
        return installMapper.realTimeMonitoring();
    }
}
