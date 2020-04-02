package com.pablo.system.controller;


import java.util.HashMap;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/20 16:09
 * @package com.pablo.vegetable.controller
 * @characterization 控制器父类
 */
public class BaseController {
    private Map<String,Object> resultMap = new HashMap<>();

    protected Map<String,Object> getResultMap(){
        return resultMap;
    }
}
