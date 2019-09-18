package com.smbms.model;

import lombok.Data;

import java.util.Date;

@Data
public class SmbmsUser {
    private Long id;

    private String userCode;

    private String userName;

    private String userPassword;

    private Integer gender;

    private Date birthday;

    private String phone;

    private String address;

    private Long userRole;

    private Long createdBy;

    private Date creationDate;

    private Long modifyBy;

    private Date modifyDate;

    private SmbmsRole role;


    public int getAge(){
        Date now = new Date();
        return now.getYear() - birthday.getYear();
    }
}