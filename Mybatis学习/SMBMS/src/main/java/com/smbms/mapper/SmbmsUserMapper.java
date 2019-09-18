package com.smbms.mapper;

import com.smbms.model.SmbmsUser;
import com.smbms.pojo.UserPojo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SmbmsUserMapper {
    List<SmbmsUser> selectAll();

    List<SmbmsUser> select(SmbmsUser user);

    SmbmsUser queryByCodePwd(@Param("userCode") String userCode, @Param("oldPassword")String oldPassword);

    void updatePwd(@Param("userCode") String userCode,@Param("newPassword") String newPassword);


    long countUserNameRole(UserPojo userPojo);


    List<SmbmsUser> queryUserNameRole(UserPojo userPojo);


    void deleteById(@Param("id") long id);


    SmbmsUser queryById(long id);


    void update(SmbmsUser user);


    void insert(SmbmsUser user);
}