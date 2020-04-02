package com.pablo.system.dao;

import com.pablo.system.domain.LtypeVo;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:12
 * @package com.pablo.system.dao
 * @characterization 设备大类数据接口映射
 */
public interface LtypeMapper {
    List<LtypeVo> queryAll();
}
