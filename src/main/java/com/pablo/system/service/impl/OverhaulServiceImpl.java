package com.pablo.system.service.impl;

import com.pablo.system.dao.EquipmentMapper;
import com.pablo.system.dao.InstallMapper;
import com.pablo.system.dao.OverhaulMapper;
import com.pablo.system.domain.OverhaulVo;
import com.pablo.system.service.OverhaulService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 19:20
 * @package com.pablo.system.service.impl
 * @characterization
 */
@Service
public class OverhaulServiceImpl implements OverhaulService {
    @Autowired
    private OverhaulMapper overhaulMapper;
    @Autowired
    private EquipmentMapper equipmentMapper;
    @Autowired
    private InstallMapper installMapper;

    /**
     * 获取所有送检记录
     *
     * @param map
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public List<Map<String, Object>> showAllOverhaulRecord(Map map) {
        return overhaulMapper.showAllOverhaulRecord(map);
    }

    /**
     * 送检操作
     *
     * @param overhaulVo
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int goToOverhauling(OverhaulVo overhaulVo, Integer eid, Map map) throws Exception {
        int result = -1;

        if (overhaulMapper.goToOverhauling(overhaulVo) > 0) {
            if (equipmentMapper.updateEquipmentStatus(map) > 0) {
                if (installMapper.queryInstallNoteByEid(eid) != null)
                    if (installMapper.deleteInstallNoteByEid(overhaulVo.getEid()) > 0)
                        result = 1;
                    else
                        throw new Exception();
                else
                    result = 1;
            } else
                throw new Exception();
        }
        return result;
    }

    /**
     * 获取送检列表总条目数
     *
     * @return
     */
    @Override
    @Transactional(readOnly = true)
    public int getRecordCount() {
        return overhaulMapper.getRecordCount();
    }

    /**
     * 更新状态
     *
     * @param eoid
     * @param is_take_back
     * @param map
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
    public int updateStatus(Integer is_take_back, Integer eoid, Map map) throws Exception {
        int result;

        if (overhaulMapper.updateStatus(is_take_back, eoid) > 0)
            if (equipmentMapper.updateEquipmentStatus(map) > 0)
                result = 1;
            else
                throw new Exception();
        else
            throw new Exception();

        return result;
    }
}
