package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/29 19:09
 * @package com.pablo.system.domain
 * @characterization 检修实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OverhaulVo implements Serializable {
    private Integer eoid;
    private Integer eid;
    private String overhaul_handle;
    private String overhaul_time;
    private Integer status;
    private Integer is_take_back;

    public OverhaulVo(Integer eid, String overhaul_handle, String overhaul_time) {
        this.eid = eid;
        this.overhaul_handle = overhaul_handle;
        this.overhaul_time = overhaul_time;
    }
}
