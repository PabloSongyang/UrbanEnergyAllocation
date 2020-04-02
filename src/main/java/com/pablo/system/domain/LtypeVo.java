package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 14:00
 * @package com.pablo.system.domain
 * @characterization 设备大类实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LtypeVo implements Serializable {
    private Integer etid;
    private String etname;
}
