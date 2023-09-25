package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Overtime;

import java.util.List;

public interface OvertimeService {
    /**
     * 查询所有加班信息（分页）
     */
    PageInfo<Overtime> queryOvertimeAll(Overtime overtime, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addOvertimeSubmit(Overtime overtime);

    /**
     * 根据id查询（修改）
     */
    Overtime queryOvertimeById(Integer id);

    /**
     * 修改提交
     */
    void updateOvertimeSubmit(Overtime overtime);

    /**
     * 删除
     */
    void deleteOvertimeByIds(List<String> ids);
}
