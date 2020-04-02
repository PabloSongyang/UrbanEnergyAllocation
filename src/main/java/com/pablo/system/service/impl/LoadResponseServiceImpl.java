package com.pablo.system.service.impl;

import com.pablo.system.dao.LoadResponseMapper;
import com.pablo.system.domain.LoadResponseVo;
import com.pablo.system.service.LoadResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/2 16:12
 * @package com.pablo.system.service.impl
 * @characterization 负荷响应事务层接口
 */
@Service
public class LoadResponseServiceImpl implements LoadResponseService {
    @Autowired
    private LoadResponseMapper loadResponseMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int addLoadResponseNote(LoadResponseVo loadResponseVo) {
        return loadResponseMapper.addLoadResponseNote(loadResponseVo);
    }
}
