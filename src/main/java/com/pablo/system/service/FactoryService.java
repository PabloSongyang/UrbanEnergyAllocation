package com.pablo.system.service;

import com.pablo.system.domain.FactoryVo;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:32
 * @package com.pablo.system.service
 * @characterization 生产厂家事务层接口
 */
public interface FactoryService {
    List<FactoryVo> queryAll();
}
