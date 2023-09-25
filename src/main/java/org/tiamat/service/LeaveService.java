package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Leave;

import java.util.List;

public interface LeaveService {
    /**
     * 查询所有休假信息（分页）
     */
    PageInfo<Leave> queryLeaveAll(Leave leave, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addLeaveSubmit(Leave leave);

    /**
     * 根据id查询（修改）
     */
    Leave queryLeaveById(Integer id);

    /**
     * 修改提交
     */
    void updateLeaveSubmit(Leave leave);

    /**
     * 删除
     */
    void deleteLeaveByIds(List<String> ids);
}
