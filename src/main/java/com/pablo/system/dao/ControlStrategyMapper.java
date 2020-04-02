package com.pablo.system.dao;

import com.pablo.system.domain.ControlStrategyVo;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/30 14:40
 * @package com.pablo.system.dao
 * @characterization 控制策略数据接口映射
 */
public interface ControlStrategyMapper {
    /**
     * 添加策略
     *
     * @param controlStrategyVo
     * @return
     */
    int addStrategy(ControlStrategyVo controlStrategyVo);

    /**
     * 显示所有的控制策略信息
     * @param map
     * @return
     */
    List<Map<String, Object>> showAllControlStrategyList(Map map);

    /**
     * 获取所有可用的控制策略
     * @param is_enable
     * @return
     */
    List<Map<String,Object>> showAllControlStrategyListOnEnable(String is_enable);

    /**
     * 获取总条目数
     *
     * @return
     */
    int getRecordCount();

    /**
     * 删除指定条目
     * @param csid
     * @return
     */
    int deleteItem(Integer csid);

    /**
     * 更新控制策略信息
     * @param controlStrategyVo
     * @return
     */
    int modifyItem(ControlStrategyVo controlStrategyVo);
}
