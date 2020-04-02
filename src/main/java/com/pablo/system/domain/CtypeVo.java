package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 14:04
 * @package com.pablo.system.domain
 * @characterization 设备子类实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CtypeVo implements Serializable {
    private Integer ctid;
    private String ctname;
}
