package com.pablo.system.dao;

import com.pablo.system.domain.OverhaulVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 19:11
 * @package com.pablo.system.dao
 * @characterization 检修数据接口映射
 */
public interface OverhaulMapper {
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
    int goToOverhauling(OverhaulVo overhaulVo);

    /**
     * 获取总条目数
     *
     * @return
     */
    int getRecordCount();

    /**
     * 更新检修状态
     *
     * @param is_take_back
     * @param eoid
     * @return
     */
    int updateStatus(@Param("is_take_back") Integer is_take_back,@Param("eoid") Integer eoid);
}
