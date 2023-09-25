package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.AttendanceRules;

import java.util.List;

public interface AttendanceRulesService {
    /**
     * 查询所有考勤规则（分页）
     */
    PageInfo<AttendanceRules> queryAttendanceRulesAll(AttendanceRules attendanceRules, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addAttendanceRulesSubmit(AttendanceRules attendanceRules);

    /**
     * 根据id查询
     */
    AttendanceRules queryAttendanceRulesById(Integer id);

    /**
     * 修改提交
     */
    void updateAttendanceRulesSubmit(AttendanceRules attendanceRules);

    /**
     * 删除
     */
    void deleteAttendanceRulesByIds(List<String> ids);
}
