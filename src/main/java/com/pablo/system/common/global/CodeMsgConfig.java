package com.pablo.system.common.global;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/25 20:37
 * @package com.pablo.system.common.global
 * @characterization 反馈信息配置
 */
public class CodeMsgConfig {
    //对象名
    public static final String CODE                                  = "code";
    public static final String MSG                                   = "msg";
    public static final String WORKER                                = "worker";
    public static final String LTYPE                                 = "ltype";
    public static final String CYTPE                                 = "ctype";
    public static final String ETYPE                                 = "etype";
    public static final String FACTORY                               = "factory";
    public static final String EQUIPMENT                             = "equipment";
    public static final String PAGE                                  = "page";
    public static final String INSTALLED_LIST                        = "installed_list";
    public static final String OVERHAUL_LIST                         = "overhaul_list";
    public static final String CONTROL_STRATEGY_LIST                 = "control_strategy_list";
    public static final String RESPONSE_SCHEME                       = "response_scheme_list";
    public static final String RS_AND_CS                             = "rs_and_cs";

    //消息体
    public static final String MSG_ADD_SUCCESS                       = "添加成功";
    public static final String MSG_ADD_FAILED                        = "添加失败";

    public static final String MSG_GET_SUCCESS                       = "获取成功";
    public static final String MSG_GET_FAILED                        = "获取失败";

    public static final String MSG_DELETE_SUCCESS                    = "删除成功";
    public static final String MSG_DELETE_FAILED                     = "删除失败";

    public static final String MSG_MODIFY_SUCCESS                    = "修改成功";
    public static final String MSG_MODIFY_FAILED                     = "修改失败";

    public static final String MSG_UPDATE_SUCCESS                    = "更新成功";
    public static final String MSG_UPDATE_FAILED                     = "更新失败";

    public static final String MSG_LOGIN_SUCCESS                     = "登录成功";
    public static final String MSG_LOGIN_FAILED                      = "您输入密码不正确";
    public static final String MSG_LOGIN_EXCEPTION                   = "账号不存在";

    public static final String MSG_LOGOUT_SUCCESS                    = "注销成功";
    public static final String MSG_LOGOUT_EXCEPTION                  = "注销异常";

    public static final String MSG_INSTALL_SUCCESS                   = "安装成功";
    public static final String MSG_INSTALL_FAILED                    = "安装失败";

    public static final String MSG_OVERHAUL_SUCCESS                  = "发起设备送检申请成功";
    public static final String MSG_OVERHAUL_FAILED                   = "发起设备送检申请失败";

    public static final String MSG_OVERHAUL_TAKE_BACK_SUCCESS        = "收回设备成功";
    public static final String MSG_OVERHAUL_TAKE_BACK_FAILED         = "收回设备失败";


    //消息号
    public static final int CODE_ADD_SUCCESS                         = 1;
    public static final int CODE_ADD_FAILED                          = 0;

    public static final int CODE_GET_SUCCESS                         = 11;
    public static final int CODE_GET_FAILED                          = 10;

    public static final int CODE_DELETE_SUCCESS                      = 21;
    public static final int CODE_DELETE_FAILED                       = 20;

    public static final int CODE_MODIFY_SUCCESS                      = 31;
    public static final int CODE_MODIFY_FAILED                       = 30;

    public static final int CODE_UPDATE_SUCCESS                      = 41;
    public static final int CODE_UPDATE_FAILED                       = 40;

    public static final int CODE_LOGIN_FAILED                        = 100;
    public static final int CODE_LOGIN_SUCCESS                       = 101;
    public static final int CODE_LOGIN_EXCEPTION                     = 102;

    public static final int CODE_LOGOUT_SUCCESS                      = 105;
    public static final int CODE_LOGOUT_EXCEPTION                    = 106;

    public static final int CODE_INSTALL_SUCCESS                     = 201;
    public static final int CODE_INSTALL_FAILED                      = 202;

    public static final int CODE_OVERHAUL_SUCCESS                    = 301;
    public static final int CODE_OVERHAUL_FAILED                     = 302;

    public static final int CODE_OVERHAUL_TAKE_BACK_SUCCESS          = 401;
    public static final int CODE_OVERHAUL_TAKE_BACK_FAILED           = 402;
 }
