package com.pablo.system.service;

import com.pablo.system.domain.EtypeVo;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:57
 * @package com.pablo.system.service
 * @characterization 能源类别事务层接口
 */
public interface EtypeService {
    List<EtypeVo> queryAll();
}
