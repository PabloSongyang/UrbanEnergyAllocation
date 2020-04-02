package com.pablo.system.service.impl;

import com.pablo.system.common.global.GlobalConfig;
import com.pablo.system.domain.WorkerVo;
import com.pablo.system.dao.WorkerMapper;
import com.pablo.system.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/25 17:17
 * @package com.pablo.system.service.impl
 * @characterization 工作人员事务层接口实现
 */
@Service
public class WorkerServiceImpl implements WorkerService {
    @Autowired
    private WorkerMapper workerMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int addWorker(WorkerVo workerVo) {
        return workerMapper.addWorker(workerVo);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public WorkerVo login(String username) {
        WorkerVo vo = workerMapper.login(username);
        if (vo != null) {
            Map<String, Object> map = new HashMap<>();
            map.put("last_login", new SimpleDateFormat(GlobalConfig.DATE_FORMAT_ONE).format(System.currentTimeMillis()));
            map.put("uid", vo.getUid());
            this.updateLoginDate(map);
        }
        return vo;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int updateLoginDate(Map map) {
        return workerMapper.updateLoginDate(map);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int insertLoginDate(String last_login) {
        return workerMapper.insertLoginDate(last_login);
    }
}
