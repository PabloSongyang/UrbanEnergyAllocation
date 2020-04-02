package com.pablo.system.dao;

import com.pablo.system.domain.EtypeVo;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:56
 * @package com.pablo.system.dao
 * @characterization 能源类型数据接口映射
 */
public interface EtypeMapper {
    List<EtypeVo> queryAll();
}
