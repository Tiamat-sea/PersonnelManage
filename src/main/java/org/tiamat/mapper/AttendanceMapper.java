package org.tiamat.mapper;

import org.tiamat.model.Attendance;

import java.util.List;

public interface AttendanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int deleteByPrimaryKey(Integer recordid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insert(Attendance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insertSelective(Attendance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    Attendance selectByPrimaryKey(Integer recordid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKeySelective(Attendance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendance
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKey(Attendance record);

    /**
     * 查询所有考勤记录
     */
    List<Attendance> queryAttendanceAll(Attendance attendance);
}