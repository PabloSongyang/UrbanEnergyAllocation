package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/4/1 15:23
 * @package com.pablo.system.domain
 * @characterization 设备运行监测实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OperationMonitoringVo implements Serializable {
    private Integer eomid;
    private Integer eid;
    private String operate_date;
    private Double zero_hour;
    private Double one_hour;
    private Double two_hour;
    private Double three_hour;
    private Double four_hour;
    private Double five_hour;
    private Double six_hour;
    private Double seven_hour;
    private Double eight_hour;
    private Double nine_hour;
    private Double ten_hour;
    private Double eleven_hour;
    private Double twelve_hour;
    private Double thirteen_hour;
    private Double fourteen_hour;
    private Double fifteen_hour;
    private Double sixteen_hour;
    private Double seventeen_hour;
    private Double eighteen_hour;
    private Double nineteen_hour;
    private Double twenty_hour;
    private Double twentyone_hour;
    private Double twentytwo_hour;
    private Double twentythree_hour;
}
