package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.domain.LoadResponseVo;
import com.pablo.system.service.LoadResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/2 16:35
 * @package com.pablo.system.controller
 * @characterization 负荷响应控制层
 */
@RestController
public class LoadResponseController extends BaseController {
    @Autowired
    private LoadResponseService loadResponseService;

    @RequestMapping(AjaxConfig.AJAX_ADD_LOAD_RESPONSE)
    public Map<String, Object> ajax_addLoadResponseNote(LoadResponseVo loadResponseVo) {
        super.getResultMap().clear();

        loadResponseVo.setCur_date(new SimpleDateFormat(GlobalConfig.DATE_FORMAT_ONE).format(System.currentTimeMillis()));
        int result = loadResponseService.addLoadResponseNote(loadResponseVo);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_ADD_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_ADD_FAILED);
        }

        return super.getResultMap();
    }
}
