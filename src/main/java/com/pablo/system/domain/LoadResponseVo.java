package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/2 16:03
 * @package com.pablo.system.domain
 * @characterization 负荷响应评价实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LoadResponseVo implements Serializable {
    private Integer lrid;
    private Integer rsid;
    private Double regulate_target;
    private Double actual_regulation;
    private Double load_complete;
    private Double time_complete;
    private String overall_merit;
    private String cur_date;
}
