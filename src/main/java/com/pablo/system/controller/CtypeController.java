package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.domain.CtypeVo;
import com.pablo.system.service.CtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:50
 * @package com.pablo.system.controller
 * @characterization 设备子类控制器
 */
@RestController
public class CtypeController extends BaseController {
    @Autowired
    private CtypeService ctypeService;

    /**
     * 获取所有设备子类
     * @param ctypeVo
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_QUERY_ALL_CTYPE)
    public Map<String, Object> ajax_getAllCtype(CtypeVo ctypeVo) {
        super.getResultMap().clear();

        List<CtypeVo> ctypeVoList = ctypeService.queryAll();
        if (ctypeVoList.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CYTPE, ctypeVoList);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }
        return super.getResultMap();
    }
}
