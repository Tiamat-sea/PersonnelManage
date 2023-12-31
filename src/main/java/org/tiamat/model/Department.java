package org.tiamat.model;

import java.io.Serializable;

public class Department implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table department
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private static final long serialVersionUID = 1L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.DepartmentID
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private Integer departmentid;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.DepartmentName
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String departmentname;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.DepartmentFunction
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String departmentfunction;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column department.ParentDepartmentID
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private Integer parentdepartmentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.DepartmentID
     *
     * @return the value of department.DepartmentID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public Integer getDepartmentid() {
        return departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.DepartmentID
     *
     * @param departmentid the value for department.DepartmentID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.DepartmentName
     *
     * @return the value of department.DepartmentName
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getDepartmentname() {
        return departmentname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.DepartmentName
     *
     * @param departmentname the value for department.DepartmentName
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname == null ? null : departmentname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.DepartmentFunction
     *
     * @return the value of department.DepartmentFunction
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getDepartmentfunction() {
        return departmentfunction;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.DepartmentFunction
     *
     * @param departmentfunction the value for department.DepartmentFunction
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setDepartmentfunction(String departmentfunction) {
        this.departmentfunction = departmentfunction == null ? null : departmentfunction.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column department.ParentDepartmentID
     *
     * @return the value of department.ParentDepartmentID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public Integer getParentdepartmentid() {
        return parentdepartmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column department.ParentDepartmentID
     *
     * @param parentdepartmentid the value for department.ParentDepartmentID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setParentdepartmentid(Integer parentdepartmentid) {
        this.parentdepartmentid = parentdepartmentid;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentid=" + departmentid +
                ", departmentname='" + departmentname + '\'' +
                ", departmentfunction='" + departmentfunction + '\'' +
                ", parentdepartmentid=" + parentdepartmentid +
                '}';
    }
}