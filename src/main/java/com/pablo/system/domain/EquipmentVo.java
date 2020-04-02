package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/26 13:37
 * @package com.pablo.system.domain
 * @characterization 设备实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class EquipmentVo implements Serializable {
    private Integer eid;
    private Integer etid;
    private Integer fid;
    private String factory;
    private Double original_value;
    private String procurement_batches;
    private Double single_price;
    private Integer count_num;
    private Integer ctid;
    private String version_str;
    private String spec;
    private String out_date;
    private String purchaser;
    private String useto;
    private String enumber;
    private Integer eeid;
    private String units;
    private Double epower;
    private Double total_power;
    private String purchase_date;
    private Integer installed;
    private Integer overhaul;
    private Integer damage;

}
