package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Admin;

import java.util.List;

public interface AdminService {
    /**
     * 查询所有管理员（分页）
     */
    PageInfo<Admin> queryAdminAll(Admin admin, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addAdminSubmit(Admin admin);

    /**
     * 根据id查询
     */
    Admin queryAdminById(Integer id);

    /**
     * 修改提交
     */
    void updateAdminSubmit(Admin admin);

    /**
     * 删除
     */
    void deleteAdminByIds(List<String> ids);

    /**
     * 根据用户名和密码查询用户信息
     */
    Admin queryAdminByNameAndPassword(String username, String password);
}