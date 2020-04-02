package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 14:01
 * @package com.pablo.system.domain
 * @characterization 生产厂家实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactoryVo implements Serializable {
    private Integer fid;
    private String factoryname;
}
