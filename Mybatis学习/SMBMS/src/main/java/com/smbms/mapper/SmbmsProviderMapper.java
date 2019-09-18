package com.smbms.mapper;

import com.smbms.model.SmbmsProvider;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmbmsProviderMapper {
    List<SmbmsProvider> selectAll();

    List<SmbmsProvider> query(SmbmsProvider provider);


    void delete(@Param("id") Long id);

    SmbmsProvider get(@Param("id")long id);


    void update(SmbmsProvider provider);


    void insert(SmbmsProvider provider);

    List<SmbmsProvider> queryAll();
}