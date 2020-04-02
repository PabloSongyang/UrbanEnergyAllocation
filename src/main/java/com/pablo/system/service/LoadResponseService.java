package com.pablo.system.service;

import com.pablo.system.domain.LoadResponseVo;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/2 16:12
 * @package com.pablo.system.service
 * @characterization 负荷响应事务层接口
 */
public interface LoadResponseService {
    /**
     * 添加负荷响应评价记录
     * @param loadResponseVo
     * @return
     */
    int addLoadResponseNote(LoadResponseVo loadResponseVo);
}
