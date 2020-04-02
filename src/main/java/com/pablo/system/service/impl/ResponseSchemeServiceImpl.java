package com.pablo.system.service.impl;

import com.pablo.system.dao.ResponseSchemeMapper;
import com.pablo.system.domain.PagingVo;
import com.pablo.system.domain.ResponseSchemeVo;
import com.pablo.system.service.ResponseSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/30 23:41
 * @package com.pablo.system.service.impl
 * @characterization 响应方案事务层接口实现
 */
@Service
public class ResponseSchemeServiceImpl implements ResponseSchemeService {
    @Autowired
    private ResponseSchemeMapper responseSchemeMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int addResponseScheme(ResponseSchemeVo responseSchemeVo) {
        return responseSchemeMapper.addResponseScheme(responseSchemeVo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> showAllResponseScheme(Map map) {
        return responseSchemeMapper.showAllResponseScheme(map);
    }

    @Override
    @Transactional(readOnly = true)
    public int getRecordCount() {
        return responseSchemeMapper.getRecordCount();
    }

    @Override
    public int deleteResponseSchemeItem(Integer rsid) {
        return responseSchemeMapper.deleteResponseSchemeItem(rsid);
    }

    @Override
    public int addControlStrategyIntoResponseScheme(Integer rsid, Integer csid) {
        return responseSchemeMapper.addControlStrategyIntoResponseScheme(rsid, csid);
    }

    @Override
    public List<Map<String, Object>> getAddedSchemeByRsid(Integer rsid) {
        return responseSchemeMapper.getAddedSchemeByRsid(rsid);
    }
}
