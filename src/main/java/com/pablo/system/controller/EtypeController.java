package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.domain.EtypeVo;
import com.pablo.system.service.EtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 16:00
 * @package com.pablo.system.controller
 * @characterization 能源类别控制层
 */
@RestController
public class EtypeController extends BaseController {
    @Autowired
    private EtypeService etypeService;

    /**
     * 获取所有的能源类别
     * @param etypeVo
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_QUERY_ALL_ETYPE)
    public Map<String,Object> ajax_getAllEtype(EtypeVo etypeVo){
        super.getResultMap().clear();

        List<EtypeVo> etypeVoList = etypeService.queryAll();
        if (etypeVoList.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.ETYPE, etypeVoList);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }
        return super.getResultMap();
    }
}
