package org.tiamat.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class AttendanceRules implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table attendancerules
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    private static final long serialVersionUID = 1L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.id
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    private Integer id;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.name
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.startTime
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    @DateTimeFormat(pattern = "HH:mm:ss")//接收页面输入的时间，将其格式化
    @JSONField(format = "HH:mm:ss")//后端传的日期格式化
    private Date starttime;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.endTime
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    @DateTimeFormat(pattern = "HH:mm:ss")//接收页面输入的时间，将其格式化
    @JSONField(format = "HH:mm:ss")//后端传的日期格式化
    private Date endtime;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.workDays
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    private String workdays;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.lateThreshold
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    private Integer latethreshold;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.earlyThreshold
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    private Integer earlythreshold;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.overtimeAllowed
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    @DateTimeFormat(pattern = "HH:mm:ss")//接收页面输入的时间，将其格式化
    @JSONField(format = "HH:mm:ss")//后端传的日期格式化
    private Boolean overtimeallowed;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.overtimeStartTime
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    @DateTimeFormat(pattern = "HH:mm:ss")//接收页面输入的时间，将其格式化
    @JSONField(format = "HH:mm:ss")//后端传的日期格式化
    private Date overtimestarttime;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column attendancerules.overtimeEndTime
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    @DateTimeFormat(pattern = "HH:mm:ss")//接收页面输入的时间，将其格式化
    @JSONField(format = "HH:mm:ss")//后端传的日期格式化
    private Date overtimeendtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.id
     *
     * @return the value of attendancerules.id
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.id
     *
     * @param id the value for attendancerules.id
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.name
     *
     * @return the value of attendancerules.name
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.name
     *
     * @param name the value for attendancerules.name
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.startTime
     *
     * @return the value of attendancerules.startTime
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.startTime
     *
     * @param starttime the value for attendancerules.startTime
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.endTime
     *
     * @return the value of attendancerules.endTime
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.endTime
     *
     * @param endtime the value for attendancerules.endTime
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.workDays
     *
     * @return the value of attendancerules.workDays
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public String getWorkdays() {
        return workdays;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.workDays
     *
     * @param workdays the value for attendancerules.workDays
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setWorkdays(String workdays) {
        this.workdays = workdays == null ? null : workdays.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.lateThreshold
     *
     * @return the value of attendancerules.lateThreshold
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public Integer getLatethreshold() {
        return latethreshold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.lateThreshold
     *
     * @param latethreshold the value for attendancerules.lateThreshold
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setLatethreshold(Integer latethreshold) {
        this.latethreshold = latethreshold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.earlyThreshold
     *
     * @return the value of attendancerules.earlyThreshold
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public Integer getEarlythreshold() {
        return earlythreshold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.earlyThreshold
     *
     * @param earlythreshold the value for attendancerules.earlyThreshold
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setEarlythreshold(Integer earlythreshold) {
        this.earlythreshold = earlythreshold;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.overtimeAllowed
     *
     * @return the value of attendancerules.overtimeAllowed
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public Boolean getOvertimeallowed() {
        return overtimeallowed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.overtimeAllowed
     *
     * @param overtimeallowed the value for attendancerules.overtimeAllowed
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setOvertimeallowed(Boolean overtimeallowed) {
        this.overtimeallowed = overtimeallowed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.overtimeStartTime
     *
     * @return the value of attendancerules.overtimeStartTime
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public Date getOvertimestarttime() {
        return overtimestarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.overtimeStartTime
     *
     * @param overtimestarttime the value for attendancerules.overtimeStartTime
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setOvertimestarttime(Date overtimestarttime) {
        this.overtimestarttime = overtimestarttime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column attendancerules.overtimeEndTime
     *
     * @return the value of attendancerules.overtimeEndTime
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public Date getOvertimeendtime() {
        return overtimeendtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column attendancerules.overtimeEndTime
     *
     * @param overtimeendtime the value for attendancerules.overtimeEndTime
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    public void setOvertimeendtime(Date overtimeendtime) {
        this.overtimeendtime = overtimeendtime;
    }
}