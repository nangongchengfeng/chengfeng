package com.smbms.service.impl;

import com.smbms.mapper.SmbmsUserMapper;
import com.smbms.model.SmbmsUser;
import com.smbms.pojo.PageInfo;
import com.smbms.pojo.UserPojo;
import com.smbms.service.UserService;
import com.smbms.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;


public class UserServiceImpl implements UserService {
    @Override
    public SmbmsUser login(SmbmsUser user) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);
        List<SmbmsUser> l =  mapper.select(user);
        if(l!= null && l.size() > 1){
            return null;
        }else if (l.size() == 1){
            return l.get(0);
        }
        session.commit();
        session.close();
        return null;
    }

    @Override
    public SmbmsUser queryByCodePwd(String userCode, String oldPassword) {

        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);
        SmbmsUser u = mapper.queryByCodePwd(userCode,oldPassword);
        session.commit();
        session.close();
        return u;
    }

    @Override
    public void updatePwd(String userCode, String newPassword) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);
        if(userCode == null)
            return;
        mapper.updatePwd(userCode,newPassword);
        session.commit();
        session.close();
    }

    @Override
    public PageInfo<SmbmsUser> query(UserPojo userPojo) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);

        // 1 查询总条数
        long total = mapper.countUserNameRole(userPojo);
        PageInfo<SmbmsUser> pageInfo = new PageInfo<>();
        pageInfo.setPageNum(userPojo.getPageNum());
        pageInfo.setPageSize(userPojo.getPageSize());
        pageInfo.setTotal(total);

        // 2 计算分页limit  子句的写法 limit start ,num
        long start = (pageInfo.getPageNum()-1)*pageInfo.getPageSize();
        int counter = pageInfo.getPageSize();

        userPojo.setStart(start);
        userPojo.setCounter(counter);
        List<SmbmsUser> l = mapper.queryUserNameRole(userPojo);
        pageInfo.setList(l);
        session.commit();
        session.close();
        return pageInfo;
    }

    @Override
    public void deleteById(long id) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);
        mapper.deleteById(id);
        session.commit();
        session.close();
    }

    @Override
    public SmbmsUser queryById(long id) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);
        SmbmsUser u = mapper.queryById(id);
        session.commit();
        session.close();
        return u;
    }

    @Override
    public void update(SmbmsUser user) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);
        user.setModifyDate(new Date());
        mapper.update(user);
        session.commit();
        session.close();

    }

    @Override
    public void insert(SmbmsUser user) {
        SqlSession session = MybatisUtil.createSqlSession();
        SmbmsUserMapper mapper = session.getMapper(SmbmsUserMapper.class);
        user.setModifyDate(new Date());
        mapper.insert(user);
        session.commit();
        session.close();
    }
}
