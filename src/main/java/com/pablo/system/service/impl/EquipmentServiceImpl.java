package com.pablo.system.service.impl;

import com.pablo.system.dao.EquipmentMapper;
import com.pablo.system.domain.EquipmentVo;
import com.pablo.system.domain.PagingVo;
import com.pablo.system.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 14:47
 * @package com.pablo.system.service.impl
 * @characterization 设备事务层接口实现
 */
@Service
public class EquipmentServiceImpl implements EquipmentService {
    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int addEquipment(Map map) {
        return equipmentMapper.addEquipment(map);
    }

    @Override
    public List<Map<String, Object>> queryAllDataWithType(PagingVo vo) {
        return equipmentMapper.queryAllDataWithType(vo);
    }

    @Override
    public int getRecordCount() {
        return equipmentMapper.getRecordCount();
    }

    @Override
    public int updateEquipmentStatus(Map map) {
        return equipmentMapper.updateEquipmentStatus(map);
    }
}
