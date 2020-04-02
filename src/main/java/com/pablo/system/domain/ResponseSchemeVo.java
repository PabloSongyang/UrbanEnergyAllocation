package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/30 23:34
 * @package com.pablo.system.domain
 * @characterization 响应方案实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseSchemeVo implements Serializable {
    private Integer rsid;
    private String scheme_name;
    private String adjust_target;
    private String start_time;
    private String end_time;
    private Double bonus;
    private Double completed;
    private Double current_load;
}
