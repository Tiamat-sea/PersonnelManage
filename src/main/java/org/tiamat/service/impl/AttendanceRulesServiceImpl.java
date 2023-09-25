package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.AttendanceRulesMapper;
import org.tiamat.model.AttendanceRules;
import org.tiamat.service.AttendanceRulesService;

import java.util.List;

@Service("attendanceRulesService")
public class AttendanceRulesServiceImpl implements AttendanceRulesService {
    @Autowired
    private AttendanceRulesMapper attendanceRulesMapper;

    @Override
    public PageInfo<AttendanceRules> queryAttendanceRulesAll(AttendanceRules attendanceRules, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<AttendanceRules> attendanceRulesList = attendanceRulesMapper.queryAttendanceRulesAll(attendanceRules);
        return new PageInfo<>(attendanceRulesList);
    }

    @Override
    public void addAttendanceRulesSubmit(AttendanceRules attendanceRules) {
        attendanceRulesMapper.insert(attendanceRules);
    }

    @Override
    public AttendanceRules queryAttendanceRulesById(Integer id) {
        return attendanceRulesMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateAttendanceRulesSubmit(AttendanceRules attendanceRules) {
        attendanceRulesMapper.updateByPrimaryKey(attendanceRules);
    }

    @Override
    public void deleteAttendanceRulesByIds(List<String> ids) {
        for (String id : ids) {
            attendanceRulesMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}