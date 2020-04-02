package com.pablo.system.service.impl;

import com.pablo.system.dao.FactoryMapper;
import com.pablo.system.domain.FactoryVo;
import com.pablo.system.service.FactoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:33
 * @package com.pablo.system.service.impl
 * @characterization 生产厂家事务层接口实现
 */
@Service
public class FactoryServiceImpl implements FactoryService {
    @Autowired
    private FactoryMapper factoryMapper;

    @Override
    @Transactional(readOnly = true)
    public List<FactoryVo> queryAll() {
        return factoryMapper.queryAll();
    }
}
