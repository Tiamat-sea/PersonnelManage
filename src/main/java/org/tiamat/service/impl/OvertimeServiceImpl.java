package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.OvertimeMapper;
import org.tiamat.model.Overtime;
import org.tiamat.service.OvertimeService;

import java.util.List;

@Service("overtimeService")
public class OvertimeServiceImpl implements OvertimeService {
    @Autowired
    private OvertimeMapper overtimeMapper;

    @Override
    public PageInfo<Overtime> queryOvertimeAll(Overtime overtime, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Overtime> overtimeList = overtimeMapper.queryOvertimeAll(overtime);
        return new PageInfo<>(overtimeList);
    }

    @Override
    public void addOvertimeSubmit(Overtime overtime) {
        overtimeMapper.insert(overtime);
    }

    @Override
    public Overtime queryOvertimeById(Integer id) {
        return overtimeMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateOvertimeSubmit(Overtime overtime) {
        overtimeMapper.updateByPrimaryKey(overtime);
    }

    @Override
    public void deleteOvertimeByIds(List<String> ids) {
        for (String id : ids) {
            overtimeMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
