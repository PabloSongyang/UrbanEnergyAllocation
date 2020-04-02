package com.pablo.system.common.global;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/25 20:33
 * @package com.pablo.system.common.global
 * @characterization AJAX接口配置
 */
public class AjaxConfig {
    //用户登录
    public static final String AJAX_ADD_WORKER                                 = "/ajax_add_work";
    public static final String AJAX_LOGIN                                      = "/ajax_login";
    public static final String AJAX_LOGOUT                                     = "/ajax_logout";
    public static final String AJAX_GET_CURRENT_WORKER_INFO                    = "/ajax_current_worker";

    //设备列表
    public static final String AJAX_ADD_EQUIPMENT_INFO                         = "/ajax_add_equipment";
    public static final String AJAX_QUERY_ALL_EQUIPMENT_INFORMATION            = "/ajax_get_all_equipment";


    public static final String AJAX_QUERY_ALL_LTYPE                            = "/ajax_get_all_ltype";

    public static final String AJAX_QUERY_ALL_FACTORY                          = "/ajax_get_all_factory";

    public static final String AJAX_QUERY_ALL_CTYPE                            = "/ajax_get_all_ctype";

    public static final String AJAX_QUERY_ALL_ETYPE                            = "/ajax_get_all_etype";

    //安装
    public static final String AJAX_INSTALLED_EQUIPMENT                        = "/ajax_install_equipment";
    public static final String AJAX_INSTALLED_LIST                             = "/ajax_install_list";

    //检修
    public static final String AJAX_OVERHAUL_EQUIPMENT                         = "/ajax_overhaul_equipment";
    public static final String AJAX_OVERHAUL_LIST                              = "/ajax_overhaul_list";
    public static final String AJAX_OVERHAUL_TAKE_BACK                         = "/ajax_overhaul_take_back";

    //控制策略
    public static final String AJAX_ADD_CONTROL_STRATEGY                       = "/ajax_add_control_strategy";
    public static final String AJAX_CONTROL_STRATEGY_LIST                      = "/ajax_control_strategy_list";
    public static final String AJAX_CONTROL_STRATEGY_LIST_ON_ENABLE            = "/ajax_control_strategy_list_on_enable";
    public static final String AJAX_DELETE_STRATEGY_ITEM                       = "/ajax_delete_strategy_item";
    public static final String AJAX_UPDATE_STRATEGY_INFO                       = "/ajax_update_strategy_info";

    //响应方案
    public static final String AJAX_ADD_RESPONSE_SCHEME                        = "/ajax_add_response_scheme";
    public static final String AJAX_RESPONSE_SCHEME_LIST                       = "/ajax_response_scheme_list";
    public static final String AJAX_DELETE_SCHEME_ITEM                         = "/ajax_delete_scheme_item";
    public static final String AJAX_ADD_CONTROL_STRATEGY_INTO_RESPONSE_SCHEME  = "/ajax_add_control_strategy_into_response_scheme";
    public static final String AJAX_GET_ADDED_SCHEME_BY_RSID                   = "/ajax_get_added_scheme_by_rsid";

    //运行监测
    public static final String AJAX_OPERATION_MONITORING                       = "/ajax_operation_monitoring";

    //负荷响应评价
    public static final String AJAX_ADD_LOAD_RESPONSE                          = "/ajax_add_load_response";
}
