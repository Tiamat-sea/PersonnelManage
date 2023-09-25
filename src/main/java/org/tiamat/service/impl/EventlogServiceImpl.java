package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.EventlogMapper;
import org.tiamat.model.Eventlog;
import org.tiamat.service.EventlogService;

import java.util.List;

@Service("eventlogService")
public class EventlogServiceImpl implements EventlogService {
    @Autowired
    private EventlogMapper eventlogMapper;

    @Override
    public PageInfo<Eventlog> queryEventlogAll(Eventlog eventlog, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Eventlog> eventlogList = eventlogMapper.queryEventlogAll(eventlog);
        return new PageInfo<>(eventlogList);
    }

    @Override
    public void addEventlogSubmit(Eventlog eventlog) {
        eventlogMapper.insert(eventlog);
    }

    @Override
    public Eventlog queryEventlogById(Integer id) {
        return eventlogMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateEventlogSubmit(Eventlog eventlog) {
        eventlogMapper.updateByPrimaryKey(eventlog);
    }

    @Override
    public void deleteEventlogByIds(List<String> ids) {
        for (String id : ids) {
            eventlogMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
