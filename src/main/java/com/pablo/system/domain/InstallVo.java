package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 16:26
 * @package com.pablo.system.domain
 * @characterization 安装设备实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InstallVo {
    private Integer eiid;
    private Integer eid;
    private String install_time;

    public InstallVo(Integer eid, String install_time) {
        this.eid = eid;
        this.install_time = install_time;
    }
}
