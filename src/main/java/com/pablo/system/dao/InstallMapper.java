package com.pablo.system.dao;

import com.pablo.system.domain.InstallVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 16:27
 * @package com.pablo.system.dao
 * @characterization 设备安装数据接口映射
 */
public interface InstallMapper {
    /**
     * 安装设备
     * @param installVo
     * @return
     */
    int installEquipment(InstallVo installVo);

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
    InstallVo queryInstallNoteByEid(@Param("eid") Integer eid);

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
