package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/30 14:29
 * @package com.pablo.system.domain
 * @characterization 控制策略实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ControlStrategyVo implements Serializable {
    private Integer csid;
    private String strategy_name;
    private Double target_load;
    private String strategy_analyze;
    private String start_time;
    private String end_time;
    private String is_enable;

    public ControlStrategyVo(String strategy_name, Double target_load, String strategy_analyze, String start_time, String end_time, String is_enable) {
        this.strategy_name = strategy_name;
        this.target_load = target_load;
        this.strategy_analyze = strategy_analyze;
        this.start_time = start_time;
        this.end_time = end_time;
        this.is_enable = is_enable;
    }
}
