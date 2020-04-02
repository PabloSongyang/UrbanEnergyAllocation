package com.pablo.system.service;

import com.pablo.system.domain.CtypeVo;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:47
 * @package com.pablo.system.service
 * @characterization 设备子类事务层接口
 */
public interface CtypeService {
    List<CtypeVo> queryAll();
}
