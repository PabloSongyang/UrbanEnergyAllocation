package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.domain.InstallVo;
import com.pablo.system.domain.PagingVo;
import com.pablo.system.service.InstallService;
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
 * @time 2020/3/29 16:37
 * @package com.pablo.system.controller
 * @characterization 安装设备控制层
 */
@RestController
public class InstallController extends BaseController {
    @Autowired
    private InstallService installService;

    /**
     * 安装设备
     *
     * @param eid
     * @return
     * @throws Exception
     */
    @RequestMapping(AjaxConfig.AJAX_INSTALLED_EQUIPMENT)
    public Map<String, Object> ajax_install(@RequestParam Integer eid) throws Exception {
        super.getResultMap().clear();

        InstallVo installVo = new InstallVo(eid, new SimpleDateFormat(GlobalConfig.DATE_FORMAT_ONE).format(System.currentTimeMillis()));
        Map<String, Object> map = new HashMap<>();
        map.put("installed", 1);
        map.put("overhaul", 0);
        map.put("eid", eid);
        int result = installService.installEquipment(installVo, map);
        if (result != -1) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_INSTALL_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_INSTALL_SUCCESS);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_INSTALL_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_INSTALL_FAILED);
        }
        return super.getResultMap();
    }

    /**
     * 获取已经安装的设备
     *
     * @param map
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_INSTALLED_LIST)
    public Map<String, Object> ajax_showInstalledList(@RequestParam Map map) {
        super.getResultMap().clear();
        int recordCount = installService.getRecordCount();

        PagingVo pagingVo = new PagingVo(recordCount, 10, Integer.parseInt(map.get("current_page").toString()));

        map.put("start_num", pagingVo.getStart_num());
        map.put("single_page_count", pagingVo.getSingle_page_count());

        List<Map<String, Object>> list = installService.showInstalledList(map);
        if (list.size() > 0) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.INSTALLED_LIST, list);
            super.getResultMap().put(CodeMsgConfig.PAGE, pagingVo);
        } else {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_GET_FAILED);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_GET_FAILED);
        }
        return super.getResultMap();
    }
}
