package org.tiamat.model;

import java.io.Serializable;

public class Report implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table report
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private static final long serialVersionUID = 1L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.ReportID
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private Integer reportid;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.ReportName
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String reportname;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.ReportType
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String reporttype;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column report.ReportContent
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String reportcontent;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.ReportID
     *
     * @return the value of report.ReportID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public Integer getReportid() {
        return reportid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.ReportID
     *
     * @param reportid the value for report.ReportID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setReportid(Integer reportid) {
        this.reportid = reportid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.ReportName
     *
     * @return the value of report.ReportName
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getReportname() {
        return reportname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.ReportName
     *
     * @param reportname the value for report.ReportName
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setReportname(String reportname) {
        this.reportname = reportname == null ? null : reportname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.ReportType
     *
     * @return the value of report.ReportType
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getReporttype() {
        return reporttype;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.ReportType
     *
     * @param reporttype the value for report.ReportType
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setReporttype(String reporttype) {
        this.reporttype = reporttype == null ? null : reporttype.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column report.ReportContent
     *
     * @return the value of report.ReportContent
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getReportcontent() {
        return reportcontent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column report.ReportContent
     *
     * @param reportcontent the value for report.ReportContent
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setReportcontent(String reportcontent) {
        this.reportcontent = reportcontent == null ? null : reportcontent.trim();
    }
}