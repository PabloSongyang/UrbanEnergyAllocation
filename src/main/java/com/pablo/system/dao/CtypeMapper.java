package com.pablo.system.dao;

import com.pablo.system.domain.CtypeVo;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:46
 * @package com.pablo.system.dao
 * @characterization 设备子类数据接口映射
 */
public interface CtypeMapper {
    List<CtypeVo> queryAll();
}
