package org.tiamat.mapper;

import org.tiamat.model.Salary;

import java.util.List;

public interface SalaryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int deleteByPrimaryKey(Integer recordid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insert(Salary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insertSelective(Salary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    Salary selectByPrimaryKey(Integer recordid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKeySelective(Salary record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table salary
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKey(Salary record);

    /**
     * 查询所有工资记录
     */
    List<Salary> querySalaryAll(Salary salary);
}