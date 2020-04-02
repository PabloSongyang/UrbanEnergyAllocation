package com.pablo.system.dao;

import com.pablo.system.domain.LoadResponseVo;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/2 16:08
 * @package com.pablo.system.dao
 * @characterization 负荷响应数据接口映射
 */
public interface LoadResponseMapper {
    /**
     * 添加负荷响应评价记录
     * @param loadResponseVo
     * @return
     */
    int addLoadResponseNote(LoadResponseVo loadResponseVo);
}
