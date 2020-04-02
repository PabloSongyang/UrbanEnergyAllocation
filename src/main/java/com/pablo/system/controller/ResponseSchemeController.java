package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.domain.PagingVo;
import com.pablo.system.domain.ResponseSchemeVo;
import com.pablo.system.service.ResponseSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/30 23:43
 * @package com.pablo.system.controller
 * @characterization 响应方案控制层
 */
@RestController
public class ResponseSchemeController extends BaseController {
    @Autowired
    private ResponseSchemeService responseSchemeService;

    /**
     * 添加响应方案
     *
     * @param responseSchemeVo
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_ADD_RESPONSE_SCHEME)
    public Map<String, Object> ajax_addResponseScheme(ResponseSchemeVo responseSchemeVo) {
        super.getResultMap().clear();

        int result = responseSchemeService.addResponseScheme(responseSchemeVo);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_FAILED);
        }

        return super.getResultMap();
    }

    /**
     * 显示所有的响应方案记录
     *
     * @param map
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_RESPONSE_SCHEME_LIST)
    public Map<String, Object> ajax_showAllResponseScheme(@RequestParam Map map) {
        super.getResultMap().clear();

        System.out.println(map);
        int recordCount = responseSchemeService.getRecordCount();

        PagingVo pagingVo = new PagingVo(recordCount, 10, Integer.parseInt(map.get("current_page").toString()));

        map.put("single_page_count", pagingVo.getSingle_page_count());
        map.put("start_num", pagingVo.getStart_num());

        List<Map<String, Object>> mapList = responseSchemeService.showAllResponseScheme(map);
        if (mapList.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.RESPONSE_SCHEME, mapList);
            super.getResultMap().put(CodeMsgConfig.PAGE, pagingVo);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }

        return super.getResultMap();
    }

    /**
     * 删除指定响应方案条目
     *
     * @param rsid
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_DELETE_SCHEME_ITEM)
    public Map<String, Object> ajax_deleteSchemeItem(Integer rsid) {
        super.getResultMap().clear();

        int result = responseSchemeService.deleteResponseSchemeItem(rsid);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_DELETE_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_DELETE_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_DELETE_FAILED);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_DELETE_FAILED);
        }

        return super.getResultMap();
    }

    /**
     * 向响应方案中添加控制策略
     *
     * @param rsid
     * @param csid
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_ADD_CONTROL_STRATEGY_INTO_RESPONSE_SCHEME)
    public Map<String, Object> ajax_addControlStrategyIntoResponseScheme(Integer rsid, Integer csid) {
        super.getResultMap().clear();

        int result = responseSchemeService.addControlStrategyIntoResponseScheme(rsid, csid);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_FAILED);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_FAILED);
        }

        return super.getResultMap();
    }

    /**
     * 根据rsid获取所有的对应添加过的策略条目信息
     * @param rsid
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_GET_ADDED_SCHEME_BY_RSID)
    public Map<String, Object> ajax_getAddedSchemeByRsid(Integer rsid) {
        super.getResultMap().clear();

        List<Map<String, Object>> list = responseSchemeService.getAddedSchemeByRsid(rsid);
        if (list.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.RS_AND_CS, list);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }

        return super.getResultMap();
    }
}
