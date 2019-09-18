package com.smbms.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class SmbmsBill {
    private Long id;

    private String billCode;

    private String productName;

    private String productDesc;

    private String productUnit;

    private BigDecimal productCount;

    private BigDecimal totalPrice;

    private Integer isPayment;

    private Long createdBy;

    private Date creationDate;

    private Long modifyBy;

    private Date modifyDate;

    private Long providerId;

    private SmbmsProvider provider;



}