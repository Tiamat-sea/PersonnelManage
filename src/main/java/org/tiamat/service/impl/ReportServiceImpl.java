package org.tiamat.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tiamat.mapper.ReportMapper;
import org.tiamat.model.Report;
import org.tiamat.service.ReportService;

import java.util.List;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportMapper reportMapper;

    @Override
    public PageInfo<Report> queryReportAll(Report report, Integer pageNum, Integer limit) {
        PageHelper.startPage(pageNum, limit);
        List<Report> reportList = reportMapper.queryReportAll(report);
        return new PageInfo<>(reportList);
    }

    @Override
    public void addReportSubmit(Report report) {
        reportMapper.insert(report);
    }

    @Override
    public Report queryReportById(Integer id) {
        return reportMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateReportSubmit(Report report) {
        reportMapper.updateByPrimaryKey(report);
    }

    @Override
    public void deleteReportByIds(List<String> ids) {
        for (String id : ids) {
            reportMapper.deleteByPrimaryKey(Integer.parseInt(id));
        }
    }
}
