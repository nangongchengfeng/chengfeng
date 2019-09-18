package com.smbms.mapper;

import com.smbms.model.SmbmsBill;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmbmsBillMapper {
    List<SmbmsBill> selectAll();

    List<SmbmsBill> query(SmbmsBill bill);

    void delete(@Param("id") long id);


    SmbmsBill get(@Param("id")long id);

    void update(SmbmsBill bill);


    void insert(SmbmsBill bill);
}