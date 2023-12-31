package org.tiamat.mapper;

import org.tiamat.model.Leave;

import java.util.List;

public interface LeaveMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int deleteByPrimaryKey(Integer leaveid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insert(Leave record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insertSelective(Leave record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    Leave selectByPrimaryKey(Integer leaveid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKeySelective(Leave record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leave
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKey(Leave record);

    /**
     * 查询所有休假信息
     */
    List<Leave> queryLeaveAll(Leave leave);
}