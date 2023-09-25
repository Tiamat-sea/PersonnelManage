package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.LeaveMapper;
import org.tiamat.model.Leave;
import org.tiamat.service.LeaveService;

import java.util.List;

@Service("leaveService")
public class LeaveServiceImpl implements LeaveService {
    @Autowired
    private LeaveMapper leaveMapper;

    @Override
    public PageInfo<Leave> queryLeaveAll(Leave leave, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Leave> leaveList = leaveMapper.queryLeaveAll(leave);
        return new PageInfo<>(leaveList);
    }

    @Override
    public void addLeaveSubmit(Leave leave) {
        leaveMapper.insert(leave);
    }

    @Override
    public Leave queryLeaveById(Integer id) {
        return leaveMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateLeaveSubmit(Leave leave) {
        leaveMapper.updateByPrimaryKey(leave);
    }

    @Override
    public void deleteLeaveByIds(List<String> ids) {
        for (String id : ids) {
            leaveMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
