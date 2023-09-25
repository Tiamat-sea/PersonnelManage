package org.tiamat.mapper;

import org.tiamat.model.Eventlog;

import java.util.List;

public interface EventlogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eventlog
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int deleteByPrimaryKey(Integer logid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eventlog
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insert(Eventlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eventlog
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int insertSelective(Eventlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eventlog
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    Eventlog selectByPrimaryKey(Integer logid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eventlog
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKeySelective(Eventlog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table eventlog
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    int updateByPrimaryKey(Eventlog record);

    /**
     * 查询所有事件日志
     */
    List<Eventlog> queryEventlogAll(Eventlog eventlog);
}