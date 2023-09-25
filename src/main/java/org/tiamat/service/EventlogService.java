package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Eventlog;

import java.util.List;

public interface EventlogService {
    /**
     * 查询所有事件日志（分页）
     */
    PageInfo<Eventlog> queryEventlogAll(Eventlog eventlog, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addEventlogSubmit(Eventlog eventlog);

    /**
     * 根据id查询（修改）
     */
    Eventlog queryEventlogById(Integer id);

    /**
     * 修改提交
     */
    void updateEventlogSubmit(Eventlog eventlog);

    /**
     * 删除
     */
    void deleteEventlogByIds(List<String> ids);
}
