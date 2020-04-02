package com.pablo.system.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/25 17:08
 * @package com.pablo.system.dao
 * @characterization 工作人员实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class WorkerVo implements Serializable {
    private Integer uid;
    private String username;
    private String password;
    private Integer status;
    private String name;
    private String last_login;

    public WorkerVo(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
