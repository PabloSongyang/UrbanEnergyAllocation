package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.domain.ControlStrategyVo;
import com.pablo.system.domain.PagingVo;
import com.pablo.system.service.ControlStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/30 14:54
 * @package com.pablo.system.controller
 * @characterization 控制策略控制层
 */
@RestController
public class ControlStrategyController extends BaseController {
    @Autowired
    private ControlStrategyService controlStrategyService;

    /**
     * 添加控制策略信息
     *
     * @param controlStrategyVo
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_ADD_CONTROL_STRATEGY)
    public Map<String, Object> ajax_addControlStrategy(ControlStrategyVo controlStrategyVo) {
        super.getResultMap().clear();

        int result = controlStrategyService.addStrategy(controlStrategyVo);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_FAILED);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_FAILED);
        }
        return super.getResultMap();
    }

    /**
     * 显示控制策略信息
     *
     * @param map
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_CONTROL_STRATEGY_LIST)
    public Map<String, Object> ajax_showControlStrategyList(@RequestParam Map map) {
        super.getResultMap().clear();
        int recordCount = controlStrategyService.getRecordCount();
        PagingVo pagingVo = new PagingVo(recordCount, 10, Integer.parseInt(map.get("current_page").toString()));

        map.put("strategy_name", map.get("strategy_name"));
        map.put("single_page_count", pagingVo.getSingle_page_count());
        map.put("start_num", pagingVo.getStart_num());

        List<Map<String, Object>> mapList = controlStrategyService.showAllControlStrategyList(map);
        if (mapList.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CONTROL_STRATEGY_LIST, mapList);
            super.getResultMap().put(CodeMsgConfig.PAGE, pagingVo);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }
        return super.getResultMap();
    }

    /**
     * 显示所有可用的控制策略信息
     * @param is_enable
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_CONTROL_STRATEGY_LIST_ON_ENABLE)
    public Map<String,Object> ajax_showControlStrategyListOnEnable(String is_enable){
        super.getResultMap().clear();

        List<Map<String,Object>> mapList = controlStrategyService.showAllControlStrategyListOnEnable(is_enable);
        if (mapList.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CONTROL_STRATEGY_LIST, mapList);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }

        return super.getResultMap();
    }

    /**
     * 删除指定控制策略条目信息
     *
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_DELETE_STRATEGY_ITEM)
    public Map<String, Object> ajax_deleteStrategyItem(Integer csid) {
        super.getResultMap().clear();

        int result = controlStrategyService.deleteItem(csid);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_DELETE_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_DELETE_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_DELETE_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_DELETE_FAILED);
        }
        return super.getResultMap();
    }

    /**
     * 更新控制策略信息
     * @param controlStrategyVo
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_UPDATE_STRATEGY_INFO)
    public Map<String, Object> ajax_updateInfo(ControlStrategyVo controlStrategyVo) {
        super.getResultMap().clear();

        int result = controlStrategyService.modifyItem(controlStrategyVo);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_MODIFY_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_MODIFY_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_MODIFY_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_MODIFY_FAILED);
        }

        return super.getResultMap();
    }
}
