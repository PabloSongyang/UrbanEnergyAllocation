package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.domain.FactoryVo;
import com.pablo.system.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:38
 * @package com.pablo.system.controller
 * @characterization 生产厂家类别控制器
 */
@RestController
public class FactoryController extends BaseController{
    @Autowired
    private FactoryService factoryService;

    /**
     * 获取所有的生产厂家类别信息
     * @param factoryVo
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_QUERY_ALL_FACTORY)
    public Map<String,Object> ajax_queryAllFactoryInfo(FactoryVo factoryVo){
        super.getResultMap().clear();

        List<FactoryVo> factoryVoList = factoryService.queryAll();
        if (factoryVoList.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.FACTORY, factoryVoList);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }
        return super.getResultMap();
    }
}
