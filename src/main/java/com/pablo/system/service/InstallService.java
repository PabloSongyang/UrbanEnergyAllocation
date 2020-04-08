package com.pablo.system.service;

import com.pablo.system.domain.InstallVo;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 16:28
 * @package com.pablo.system.service
 * @characterization 安装设备事务层接口
 */
public interface InstallService {
    /**
     * 安装设备
     * @param installVo
     * @param map
     * @return
     * @throws Exception
     */
    int installEquipment(InstallVo installVo, Map map) throws Exception;

    /**
     * 删除指定安装的条目项
     * @param eid
     * @return
     */
    int deleteInstallNoteByEid(Integer eid);

    /**
     * 显示所有已经安装的设备列表
     * @param map
     * @return
     */
    List<Map<String,Object>> showInstalledList(Map map);

    /**
     * 获取总条目数
     *
     * @return
     */
    int getRecordCount();

    /**
     * 按照安装序号查询
     * @param eid
     * @return
     */
    InstallVo queryInstallNoteByEid(Integer eid);

    /**
     * 显示所有已经安装的设备列表
     * @return
     */
    List<Map<String,Object>> realTimeMonitoring();

    /**
     * 获取额定功率总和
     * @return
     */
    Map<String,Object> getTotalPower();
}
