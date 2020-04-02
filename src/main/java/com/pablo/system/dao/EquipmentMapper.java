package com.pablo.system.dao;


import com.pablo.system.domain.PagingVo;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 14:45
 * @package com.pablo.system.dao
 * @characterization 设备数据接口映射
 */
public interface EquipmentMapper {
    /**
     * 添加设备
     *
     * @param map
     * @return
     */
    int addEquipment(Map map);

    /**
     * 查询所有设备
     *
     * @param vo
     * @return
     */
    List<Map<String, Object>> queryAllDataWithType(PagingVo vo);

    /**
     * 获取总条目数
     *
     * @return
     */
    int getRecordCount();

    /**
     * 更新设备状态
     *
     * @param map
     * @return
     */
    int updateEquipmentStatus(Map map);
}
