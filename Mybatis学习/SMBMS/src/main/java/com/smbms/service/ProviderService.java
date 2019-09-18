package com.smbms.service;

import com.smbms.model.SmbmsProvider;

import java.util.List;

public interface ProviderService {
    List<SmbmsProvider> query(SmbmsProvider provider);

    void delete(Long id);


    SmbmsProvider get(Long id);

    void update(SmbmsProvider provider);

    void add(SmbmsProvider provider);


    List<SmbmsProvider> queryAll();

}
