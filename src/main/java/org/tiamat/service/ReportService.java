package org.tiamat.service;

import com.github.pagehelper.PageInfo;
import org.tiamat.model.Report;

import java.util.List;

public interface ReportService {
    /**
     * 查询所有报表信息（分页）
     */
    PageInfo<Report> queryReportAll(Report report, Integer pageNum, Integer limit);

    /**
     * 添加提交
     */
    void addReportSubmit(Report report);

    /**
     * 根据id查询（修改）
     */
    Report queryReportById(Integer id);

    /**
     * 修改提交
     */
    void updateReportSubmit(Report report);

    /**
     * 删除
     */
    void deleteReportByIds(List<String> ids);
}
