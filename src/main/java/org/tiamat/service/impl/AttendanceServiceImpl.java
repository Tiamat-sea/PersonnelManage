package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.AttendanceMapper;
import org.tiamat.model.Attendance;
import org.tiamat.service.AttendanceService;

import java.util.List;

@Service("attendanceService")
public class AttendanceServiceImpl implements AttendanceService {
    @Autowired
    private AttendanceMapper attendanceMapper;

    @Override
    public PageInfo<Attendance> queryAttendanceAll(Attendance attendance, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Attendance> attendanceList = attendanceMapper.queryAttendanceAll(attendance);
        return new PageInfo<>(attendanceList);
    }

    @Override
    public void addAttendanceSubmit(Attendance attendance) {
        attendanceMapper.insert(attendance);
    }

    @Override
    public Attendance queryAttendanceById(Integer id) {
        return attendanceMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateAttendanceSubmit(Attendance attendance) {
        attendanceMapper.updateByPrimaryKey(attendance);
    }

    @Override
    public void deleteAttendanceByIds(List<String> ids) {
        for (String id : ids) {
            attendanceMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
