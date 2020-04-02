package com.pablo.system.dao;

import com.pablo.system.domain.FactoryVo;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:31
 * @package com.pablo.system.dao
 * @characterization 生产厂家数据接口映射
 */
public interface FactoryMapper {
    List<FactoryVo> queryAll();
}
