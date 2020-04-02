package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 14:05
 * @package com.pablo.system.domain
 * @characterization 能源类型实体
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EtypeVo implements Serializable {
    private Integer eeid;
    private String eetname;
}
