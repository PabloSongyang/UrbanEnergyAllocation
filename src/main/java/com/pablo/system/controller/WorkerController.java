package com.pablo.system.controller;

import com.pablo.system.common.global.AjaxConfig;
import com.pablo.system.common.global.CodeMsgConfig;
import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.domain.WorkerVo;
import com.pablo.system.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/25 17:32
 * @package com.pablo.system.controller
 * @characterization 工作人员控制层
 */
@RestController
public class WorkerController extends BaseController {
    @Autowired
    private WorkerService workerService;

    private HttpSession session;

    /**
     * 添加工人
     *
     * @param vo
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_ADD_WORKER)
    public Map<String, Object> ajax_addWorker(WorkerVo vo) {
        super.getResultMap().clear();
        int result = workerService.addWorker(vo);
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
     * 工人登录
     *
     * @param username
     * @param password
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_LOGIN)
    public Map<String, Object> ajax_login(String username, String password, HttpServletRequest request) {
        super.getResultMap().clear();
        WorkerVo vo = workerService.login(username);
        session = request.getSession();
        if (vo == null) {
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_LOGIN_EXCEPTION);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_LOGIN_EXCEPTION);
        } else {
            if (vo.getPassword().equals(password)) {
                super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_LOGIN_SUCCESS);
                super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_LOGIN_SUCCESS);
                super.getResultMap().put(CodeMsgConfig.WORKER, vo);
                session.setAttribute(CodeMsgConfig.WORKER, vo);
                GlobalConfig.CURRENT_WORKER = vo;
            } else {
                super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_LOGIN_FAILED);
                super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_LOGIN_FAILED);
            }
        }
        return super.getResultMap();
    }

    /**
     * 获取当前登录用户
     *
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_GET_CURRENT_WORKER_INFO)
    public Map<String, Object> ajax_getWorkerInfo() {
        super.getResultMap().clear();
        if (session.getAttribute(CodeMsgConfig.WORKER) != null) {
            WorkerVo vo = (WorkerVo) session.getAttribute(CodeMsgConfig.WORKER);
            Map<String, Object> map = new HashMap<>();
            map.put("workerName", vo.getName());
            map.put("last_login", vo.getLast_login());
            map.put("username", vo.getUsername());
            map.put("nowdate", System.currentTimeMillis());
            super.getResultMap().put("curWorker", map);
        }
        return super.getResultMap();
    }

    /**
     * 注销登录的当前用户名
     * @param request
     * @return
     */
    @RequestMapping(AjaxConfig.AJAX_LOGOUT)
    public Map<String, Object> ajax_logout(HttpServletRequest request) {
        super.getResultMap().clear();

        try {
            request.getSession().removeAttribute(CodeMsgConfig.WORKER);
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_LOGOUT_SUCCESS);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_LOGOUT_SUCCESS);
        } catch (Exception e) {
            super.getResultMap().put(CodeMsgConfig.MSG, CodeMsgConfig.MSG_LOGOUT_EXCEPTION);
            super.getResultMap().put(CodeMsgConfig.CODE, CodeMsgConfig.CODE_LOGOUT_EXCEPTION);
        }


        return super.getResultMap();
    }
}
