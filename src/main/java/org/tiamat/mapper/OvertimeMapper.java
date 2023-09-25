package org.tiamat.mapper;

import org.tiamat.model.Overtime;

import java.util.List;

public interface OvertimeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table overtime
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int deleteByPrimaryKey(Integer overtimeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table overtime
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insert(Overtime record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table overtime
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insertSelective(Overtime record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table overtime
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    Overtime selectByPrimaryKey(Integer overtimeid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table overtime
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKeySelective(Overtime record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table overtime
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKey(Overtime record);

    /**
     * 查询所有加班信息
     */
    List<Overtime> queryOvertimeAll(Overtime overtime);
}