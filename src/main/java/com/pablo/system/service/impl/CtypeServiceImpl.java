package com.pablo.system.service.impl;

import com.pablo.system.dao.CtypeMapper;
import com.pablo.system.domain.CtypeVo;
import com.pablo.system.service.CtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:47
 * @package com.pablo.system.service.impl
 * @characterization 设备子类事务层接口实现
 */
@Service
public class CtypeServiceImpl implements CtypeService {
    @Autowired
    private CtypeMapper ctypeMapper;

    @Override
    @Transactional(readOnly = true)
    public List<CtypeVo> queryAll() {
        return ctypeMapper.queryAll();
    }
}
