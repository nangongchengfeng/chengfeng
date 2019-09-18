package com.smbms.pojo;

import lombok.Data;

import java.util.List;

/**

 * 封装分页
 */
@Data
public class PageInfo <T> extends BasePage{

    private Long total;

    private Long pages;

    private List<T> list;


//    public void setTotal(Long total) {
////        this.total = total;
////        // 将pages计算一下
////
////    }

    public Long getPages(){
        return total % getPageSize() == 0 ? (total/getPageSize()):(total/getPageSize()+1);
    }
}

