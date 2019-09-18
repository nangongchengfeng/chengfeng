package com.smbms.service;

import com.smbms.model.SmbmsBill;

import java.util.List;

public interface OrderService {
    List<SmbmsBill> query(SmbmsBill bill);

    void delete(long parseLong);


    SmbmsBill get(long parseLong);

    void update(SmbmsBill bill);


    void add(SmbmsBill bill);
}
