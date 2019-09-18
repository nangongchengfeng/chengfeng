package com.smbms.service.impl;

import com.smbms.mapper.SmbmsBillMapper;
import com.smbms.model.SmbmsBill;
import com.smbms.service.OrderService;
import com.smbms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;


public class OrderServiceImpl implements OrderService {
    @Override
    public List<SmbmsBill> query(SmbmsBill bill) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsBillMapper mapper = session.getMapper(SmbmsBillMapper.class);
        List<SmbmsBill> l = mapper.query(bill);
        session.commit();
        session.close();
        return l;
    }

    @Override
    public void delete(long id) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsBillMapper mapper = session.getMapper(SmbmsBillMapper.class);
        mapper.delete(id);
        session.commit();
        session.close();

    }

    @Override
    public SmbmsBill get(long id) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsBillMapper mapper = session.getMapper(SmbmsBillMapper.class);
        SmbmsBill bill = mapper.get(id);
        session.commit();
        session.close();
        return bill;
    }

    @Override
    public void update(SmbmsBill bill) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsBillMapper mapper = session.getMapper(SmbmsBillMapper.class);
        mapper.update(bill);
        session.commit();
        session.close();
    }

    @Override
    public void add(SmbmsBill bill) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsBillMapper mapper = session.getMapper(SmbmsBillMapper.class);
        mapper.insert(bill);
        session.commit();
        session.close();

    }
}
