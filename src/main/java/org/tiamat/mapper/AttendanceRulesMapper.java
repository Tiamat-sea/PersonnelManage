package org.tiamat.mapper;

import org.tiamat.model.AttendanceRules;

import java.util.List;

public interface AttendanceRulesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendancerules
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendancerules
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    int insert(AttendanceRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendancerules
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    int insertSelective(AttendanceRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendancerules
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    AttendanceRules selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendancerules
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    int updateByPrimaryKeySelective(AttendanceRules record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table attendancerules
     *
     * @mbggenerated Sat Jul 08 22:11:27 CST 2023
     */
    int updateByPrimaryKey(AttendanceRules record);

    /**
     * 查询所有考勤规则
     */
    List<AttendanceRules> queryAttendanceRulesAll(AttendanceRules attendanceRules);
}