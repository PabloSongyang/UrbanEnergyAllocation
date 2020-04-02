package com.pablo.system.service;

import com.pablo.system.domain.InstallVo;
import com.pablo.system.domain.OverhaulVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 19:19
 * @package com.pablo.system.service
 * @characterization 送检事务层接口
 */
public interface OverhaulService {
    /**
     * 显示所有的送检信息
     *
     * @return
     */
    List<Map<String, Object>> showAllOverhaulRecord(Map map);

    /**
     * 送检操作
     *
     * @param overhaulVo
     * @return
     */
    int goToOverhauling(OverhaulVo overhaulVo,Integer eiid, Map map) throws Exception;

    /**
     * 获取总条目数
     *
     * @return
     */
    int getRecordCount();

    /**
     * 更新检修状态
     *
     * @param eoid
     * @param is_take_back
     * @param map
     * @return
     * @throws Exception
     */
    int updateStatus(Integer is_take_back, Integer eoid, Map map) throws Exception;


}
