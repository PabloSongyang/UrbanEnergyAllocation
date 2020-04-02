package com.pablo.system.service.impl;

import com.pablo.system.dao.ControlStrategyMapper;
import com.pablo.system.domain.ControlStrategyVo;
import com.pablo.system.service.ControlStrategyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/30 14:44
 * @package com.pablo.system.service.impl
 * @characterization 控制策略事务层接口实现
 */
@Service
public class ControlStrategyServiceImpl implements ControlStrategyService {
    @Autowired
    private ControlStrategyMapper controlStrategyMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int addStrategy(ControlStrategyVo controlStrategyVo) {
        return controlStrategyMapper.addStrategy(controlStrategyVo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> showAllControlStrategyList(Map map) {
        return controlStrategyMapper.showAllControlStrategyList(map);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> showAllControlStrategyListOnEnable(String is_enable) {
        return controlStrategyMapper.showAllControlStrategyListOnEnable(is_enable);
    }

    @Override
    @Transactional(readOnly = true)
    public int getRecordCount() {
        return controlStrategyMapper.getRecordCount();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int deleteItem(Integer csid) {
        return controlStrategyMapper.deleteItem(csid);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int modifyItem(ControlStrategyVo controlStrategyVo) {
        return controlStrategyMapper.modifyItem(controlStrategyVo);
    }
}
