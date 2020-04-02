package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.domain.OverhaulVo;
import com.pablo.system.domain.PagingVo;
import com.pablo.system.service.OverhaulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 20:05
 * @package com.pablo.system.controller
 * @characterization 设备检修控制层
 */
@RestController
public class OverhaulController extends BaseController {
    @Autowired
    private OverhaulService overhaulService;

    /**
     * 设备送检
     *
     * @param eid
     * @param overhaul_handle
     * @return
     * @throws Exception
     */
    @RequestMapping(AjaxConfig.AJAX_OVERHAUL_EQUIPMENT)
    public Map<String, Object> ajax_gotoOverhauling(@RequestParam Integer eid, @RequestParam String overhaul_handle) throws Exception {
        super.getResultMap().clear();

        OverhaulVo overhaulVo = new OverhaulVo(eid, overhaul_handle, new SimpleDateFormat(GlobalConfig.DATE_FORMAT_ONE).format(System.currentTimeMillis()));

        Map<String, Object> map = new HashMap<>();
        map.put("overhaul", 1);
        map.put("installed", 0);
        map.put("eid", eid);
        int result = overhaulService.goToOverhauling(overhaulVo,eid, map);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_OVERHAUL_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_OVERHAUL_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_OVERHAUL_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_OVERHAUL_FAILED);
        }

        return super.getResultMap();
    }

    /**
     * 获取已经送检的设备
     *
     * @param map
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_OVERHAUL_LIST)
    public Map<String, Object> ajax_showAllOverhaulRecord(@RequestParam Map map) {
        super.getResultMap().clear();
        int recordCount = overhaulService.getRecordCount();

        PagingVo pagingVo = new PagingVo(recordCount, 10, Integer.parseInt(map.get("current_page").toString()));

        map.put("start_num", pagingVo.getStart_num());
        map.put("single_page_count", pagingVo.getSingle_page_count());

        List<Map<String, Object>> list = overhaulService.showAllOverhaulRecord(map);
        if (list.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.OVERHAUL_LIST, list);
            super.getResultMap().put(CodeMsgConfig.PAGE, pagingVo);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }
        return super.getResultMap();
    }

    /**
     * 检修完收回
     *
     * @param eoid
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_OVERHAUL_TAKE_BACK)
    public Map<String, Object> ajax_takeBack(@RequestParam Integer eoid, @RequestParam Integer eid) throws Exception {
        super.getResultMap().clear();

        Map<String, Object> map = new HashMap<>();
        map.put("installed", 0);
        map.put("overhaul", 0);
        map.put("eid", eid);
        int result = overhaulService.updateStatus(1, eoid, map);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_OVERHAUL_TAKE_BACK_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_OVERHAUL_TAKE_BACK_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_OVERHAUL_TAKE_BACK_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_OVERHAUL_TAKE_BACK_FAILED);
        }

        return super.getResultMap();
    }
}
