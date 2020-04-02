package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.domain.EquipmentVo;
import com.pablo.system.domain.PagingVo;
import com.pablo.system.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:00
 * @package com.pablo.system.controller
 * @characterization 设备控制器
 */
@RestController
public class EquipmentController extends BaseController {
    @Autowired
    private EquipmentService equipmentService;

    /**
     * 插入设备信息
     *
     * @param map
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_ADD_EQUIPMENT_INFO)
    public Map<String, Object> ajax_addEquipment(@RequestParam Map map) {
        super.getResultMap().clear();
        System.out.println(map);
        int result = equipmentService.addEquipment(map);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_FAILED);
        }
        return super.getResultMap();
    }

    /**
     * 查询所有的设备信息
     *
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_QUERY_ALL_EQUIPMENT_INFORMATION)
    public Map<String, Object> ajax_queryAllWithType(@RequestParam Integer current_page) {
        super.getResultMap().clear();
        int recordCount = equipmentService.getRecordCount();
        PagingVo pagingVo = new PagingVo(recordCount, 10, current_page);
        List<Map<String, Object>> mapList = equipmentService.queryAllDataWithType(pagingVo);
        if (mapList.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.EQUIPMENT, mapList);
            super.getResultMap().put(CodeMsgConfig.PAGE, pagingVo);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }
        return super.getResultMap();
    }
}
