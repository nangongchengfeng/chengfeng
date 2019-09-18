package com.smbms.service;

import com.smbms.model.SmbmsUser;
import com.smbms.pojo.PageInfo;
import com.smbms.pojo.UserPojo;

public interface UserService {
    SmbmsUser login(SmbmsUser user);

    SmbmsUser queryByCodePwd(String userCode, String oldPassword);

    void updatePwd(String userCode, String newPassword);


    PageInfo<SmbmsUser> query(UserPojo userPojo);


    void deleteById(long id);


    SmbmsUser queryById(long parseLong);

    void update(SmbmsUser user);


    void insert(SmbmsUser user);

}
