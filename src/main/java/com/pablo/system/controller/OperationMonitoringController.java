package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.domain.OperationMonitoringVo;
import com.pablo.system.service.OperationMonitoringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/2 0:39
 * @package com.pablo.system.controller
 * @characterization 设备运行监测控制层
 */
@RestController
public class OperationMonitoringController extends BaseController {
    @Autowired
    private OperationMonitoringService operationMonitoringService;

    /**
     * 设备运行监测
     *
     * @param operationMonitoringVo
     * @return
     * @throws Exception
     */
    @RequestMapping(AjaxConfig.AJAX_OPERATION_MONITORING)
    public Map<String, Object> ajax_updateOperationMonitor(OperationMonitoringVo operationMonitoringVo) throws Exception {
        super.getResultMap().clear();

        int result = operationMonitoringService.updateOperationMonitor(operationMonitoringVo);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_UPDATE_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_UPDATE_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_UPDATE_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_UPDATE_FAILED);
        }

        return super.getResultMap();
    }

    /**
     * 获取每个小时的所有已安装的设备的实际总功率
     *
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_OPERATION_HOUR_TOTAL_POWER)
    public Map<String, Object> ajax_operationHourTotalPower(String operate_date) {
        super.getResultMap().clear();
        System.out.println(operate_date + " ****************");
        Map<String, Object> map = operationMonitoringService.getHourPower(operate_date);
        if (map.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.OPERATION_HOUR_TOTAL_POWER, map);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }

        return super.getResultMap();
    }
}
