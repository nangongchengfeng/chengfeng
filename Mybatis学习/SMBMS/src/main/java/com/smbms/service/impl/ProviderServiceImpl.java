package com.smbms.service.impl;

import com.smbms.mapper.SmbmsProviderMapper;
import com.smbms.model.SmbmsProvider;
import com.smbms.service.ProviderService;
import com.smbms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class ProviderServiceImpl implements ProviderService {
    @Override
    public List<SmbmsProvider> query(SmbmsProvider provider) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsProviderMapper mapper = session.getMapper(SmbmsProviderMapper.class);

        List<SmbmsProvider> l = mapper.query(provider);
        session.commit();
        session.close();
        return  l;
    }

    @Override
    public void delete(Long id) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsProviderMapper mapper = session.getMapper(SmbmsProviderMapper.class);
        if(id == null)
            return;
        mapper.delete(id);
        session.commit();
        session.close();
    }

    @Override
    public SmbmsProvider get(Long id) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsProviderMapper mapper = session.getMapper(SmbmsProviderMapper.class);
        if(id == null)
            return null;
        SmbmsProvider provider = mapper.get(id);
        session.commit();
        session.close();
        return provider;

    }

    @Override
    public void update(SmbmsProvider provider) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsProviderMapper mapper = session.getMapper(SmbmsProviderMapper.class);
        mapper.update(provider);
        session.commit();
        session.close();

    }

    @Override
    public void add(SmbmsProvider provider) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsProviderMapper mapper = session.getMapper(SmbmsProviderMapper.class);
        mapper.insert(provider);
        session.commit();
        session.close();
    }

    @Override
    public List<SmbmsProvider> queryAll() {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsProviderMapper mapper = session.getMapper(SmbmsProviderMapper.class);
        List<SmbmsProvider> providers =  mapper.queryAll();
        session.commit();
        session.close();
        return providers;
    }
}
