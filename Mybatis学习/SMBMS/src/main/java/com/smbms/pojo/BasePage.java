package com.smbms.pojo;

import lombok.Data;


@Data
public class BasePage {
    /**第多少页*/
    private Integer pageNum;
    /**页码大小*/
    private Integer pageSize = 5;

    private Long start;

    private Integer counter;


}
