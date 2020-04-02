package com.pablo.system.domain;

import lombok.Getter;

import java.io.Serializable;

/**
 * @author Pablo.风暴洋
 * @time 2020/3/27 12:13
 * @package com.pablo.system.domain
 * @characterization 分页实体类
 */
@Getter
public class PagingVo implements Serializable {
    private Integer record_count;
    private Integer page_count;
    private Integer single_page_count;
    private Integer start_num;
    private Integer current_page;

    public PagingVo(Integer record_count, Integer single_page_count, Integer current_page) {
        this.record_count = record_count;
        this.single_page_count = single_page_count;
        this.current_page = current_page;

        this.page_count = record_count % single_page_count == 0 ? record_count / single_page_count : record_count / single_page_count + 1;
        this.start_num = (current_page - 1) * single_page_count;
    }
}
