package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.domain.LtypeVo;
import com.pablo.system.service.LtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:21
 * @package com.pablo.system.controller
 * @characterization 设备大类控制器
 */
@RestController
public class LtypeController extends BaseController {
    @Autowired
    private LtypeService ltypeService;

    /**
     * 获取所有的设备大类信息
     * @param ltypeVo
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_QUERY_ALL_LTYPE)
    public Map<String,Object> ajax_getAllLtype(LtypeVo ltypeVo){
        super.getResultMap().clear();

        List<LtypeVo> ltypeVoList = ltypeService.queryAll();
        if (ltypeVoList.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.LTYPE, ltypeVoList);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }
        return super.getResultMap();
    }
}
