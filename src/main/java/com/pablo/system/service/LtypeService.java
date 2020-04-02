package com.pablo.system.service;

import com.pablo.system.domain.LtypeVo;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:16
 * @package com.pablo.system.service
 * @characterization 设备大类事务层接口
 */
public interface LtypeService {
    List<LtypeVo> queryAll();
}
