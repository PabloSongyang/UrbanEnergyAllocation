package com.pablo.system.service.impl;

import com.pablo.system.dao.LtypeMapper;
import com.pablo.system.domain.LtypeVo;
import com.pablo.system.service.LtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:16
 * @package com.pablo.system.service.impl
 * @characterization 设备大类事务层接口实现
 */
@Service
public class LtypeServiceImpl implements LtypeService {
    @Autowired
    private LtypeMapper ltypeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<LtypeVo> queryAll() {
        return ltypeMapper.queryAll();
    }
}
