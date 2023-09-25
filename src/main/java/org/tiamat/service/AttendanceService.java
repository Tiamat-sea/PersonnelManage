package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Attendance;

import java.util.List;

public interface AttendanceService {
    /**
     * 查询所有考勤信息（分页）
     */
    PageInfo<Attendance> queryAttendanceAll(Attendance attendance, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addAttendanceSubmit(Attendance attendance);

    /**
     * 根据id查询（修改）
     */
    Attendance queryAttendanceById(Integer id);

    /**
     * 修改提交
     */
    void updateAttendanceSubmit(Attendance attendance);

    /**
     * 删除
     */
    void deleteAttendanceByIds(List<String> ids);
}
