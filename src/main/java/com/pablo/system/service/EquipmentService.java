package com.pablo.system.service;


import com.pablo.system.domain.PagingVo;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 14:46
 * @package com.pablo.system.service
 * @characterization 设备事务层接口
 */
public interface EquipmentService {
    int addEquipment(Map map);

    List<Map<String, Object>> queryAllDataWithType(PagingVo vo);

    int getRecordCount();

    int updateEquipmentStatus(Map map);
}
