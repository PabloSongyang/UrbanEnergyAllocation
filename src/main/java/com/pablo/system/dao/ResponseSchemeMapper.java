package com.pablo.system.dao;

import com.pablo.system.domain.ResponseSchemeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/30 23:38
 * @package com.pablo.system.dao
 * @characterization 响应方案数据接口映射
 */
public interface ResponseSchemeMapper {
    /**
     * 新建方案
     *
     * @param responseSchemeVo
     * @return
     */
    int addResponseScheme(ResponseSchemeVo responseSchemeVo);

    /**
     * 显示所有的响应方案列表
     *
     * @param map
     * @return
     */
    List<Map<String, Object>> showAllResponseScheme(Map map);

    /**
     * 获取总条目数
     *
     * @return
     */
    int getRecordCount();

    /**
     * 删除对应条目
     *
     * @param rsid
     * @return
     */
    int deleteResponseSchemeItem(Integer rsid);

    /**
     * 向响应方案中添加控制策略
     * @param rsid
     * @param csid
     * @return
     */
    int addControlStrategyIntoResponseScheme(@Param("rsid") Integer rsid,@Param("csid") Integer csid);

    /**
     * 根据rsid获取所有的对应添加过的策略条目信息
     * @param rsid
     * @return
     */
    List<Map<String,Object>> getAddedSchemeByRsid(Integer rsid);
}
