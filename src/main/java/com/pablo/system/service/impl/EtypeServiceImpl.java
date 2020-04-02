package com.pablo.system.service.impl;

import com.pablo.system.dao.EtypeMapper;
import com.pablo.system.domain.EtypeVo;
import com.pablo.system.service.EtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 15:58
 * @package com.pablo.system.service.impl
 * @characterization 能源类别事务层接口实现
 */
@Service
public class EtypeServiceImpl implements EtypeService {
    @Autowired
    private EtypeMapper etypeMapper;


    @Override
    @Transactional(readOnly = true)
    public List<EtypeVo> queryAll() {
        return etypeMapper.queryAll();
    }
}
