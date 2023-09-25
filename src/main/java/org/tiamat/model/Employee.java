package org.tiamat.model;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Employee implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table employee
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private static final long serialVersionUID = 1L;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.EmployeeID
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private Integer employeeid;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Name
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String name;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Gender
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String gender;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Photo
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String photo;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Ethnicity
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String ethnicity;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Birthday
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收页面输入的时间，将其格式化
    @JSONField(format = "yyyy-MM-dd")//后端传的日期格式化
    private Date birthday;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.PoliticalStatus
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String politicalstatus;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Education
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String education;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.NativePlace
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String nativeplace;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.IDNumber
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String idnumber;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.ContactNumber
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String contactnumber;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.BasicSalary
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private BigDecimal basicsalary;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Username
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String username;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Password
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String password;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.DepartmentID
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private Integer departmentid;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.Position
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    private String position;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column employee.HireDate
     *
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")//接收页面输入的时间，将其格式化
    @JSONField(format = "yyyy-MM-dd")//后端传的日期格式化
    private Date hiredate;
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.EmployeeID
     *
     * @return the value of employee.EmployeeID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public Integer getEmployeeid() {
        return employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.EmployeeID
     *
     * @param employeeid the value for employee.EmployeeID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Name
     *
     * @return the value of employee.Name
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Name
     *
     * @param name the value for employee.Name
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Gender
     *
     * @return the value of employee.Gender
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getGender() {
        return gender;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Gender
     *
     * @param gender the value for employee.Gender
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Photo
     *
     * @return the value of employee.Photo
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Photo
     *
     * @param photo the value for employee.Photo
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setPhoto(String photo) {
        this.photo = photo == null ? null : photo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Ethnicity
     *
     * @return the value of employee.Ethnicity
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getEthnicity() {
        return ethnicity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Ethnicity
     *
     * @param ethnicity the value for employee.Ethnicity
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setEthnicity(String ethnicity) {
        this.ethnicity = ethnicity == null ? null : ethnicity.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Birthday
     *
     * @return the value of employee.Birthday
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Birthday
     *
     * @param birthday the value for employee.Birthday
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.PoliticalStatus
     *
     * @return the value of employee.PoliticalStatus
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getPoliticalstatus() {
        return politicalstatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.PoliticalStatus
     *
     * @param politicalstatus the value for employee.PoliticalStatus
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setPoliticalstatus(String politicalstatus) {
        this.politicalstatus = politicalstatus == null ? null : politicalstatus.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Education
     *
     * @return the value of employee.Education
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getEducation() {
        return education;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Education
     *
     * @param education the value for employee.Education
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setEducation(String education) {
        this.education = education == null ? null : education.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.NativePlace
     *
     * @return the value of employee.NativePlace
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getNativeplace() {
        return nativeplace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.NativePlace
     *
     * @param nativeplace the value for employee.NativePlace
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setNativeplace(String nativeplace) {
        this.nativeplace = nativeplace == null ? null : nativeplace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.IDNumber
     *
     * @return the value of employee.IDNumber
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getIdnumber() {
        return idnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.IDNumber
     *
     * @param idnumber the value for employee.IDNumber
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber == null ? null : idnumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.ContactNumber
     *
     * @return the value of employee.ContactNumber
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getContactnumber() {
        return contactnumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.ContactNumber
     *
     * @param contactnumber the value for employee.ContactNumber
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setContactnumber(String contactnumber) {
        this.contactnumber = contactnumber == null ? null : contactnumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.BasicSalary
     *
     * @return the value of employee.BasicSalary
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public BigDecimal getBasicsalary() {
        return basicsalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.BasicSalary
     *
     * @param basicsalary the value for employee.BasicSalary
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setBasicsalary(BigDecimal basicsalary) {
        this.basicsalary = basicsalary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Username
     *
     * @return the value of employee.Username
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Username
     *
     * @param username the value for employee.Username
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Password
     *
     * @return the value of employee.Password
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Password
     *
     * @param password the value for employee.Password
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.DepartmentID
     *
     * @return the value of employee.DepartmentID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public Integer getDepartmentid() {
        return departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.DepartmentID
     *
     * @param departmentid the value for employee.DepartmentID
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.Position
     *
     * @return the value of employee.Position
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public String getPosition() {
        return position;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.Position
     *
     * @param position the value for employee.Position
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column employee.HireDate
     *
     * @return the value of employee.HireDate
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public Date getHiredate() {
        return hiredate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column employee.HireDate
     *
     * @param hiredate the value for employee.HireDate
     * @mbggenerated Fri Jun 23 13:34:01 CST 2023
     */
    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeid=" + employeeid +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", photo='" + photo + '\'' +
                ", ethnicity='" + ethnicity + '\'' +
                ", birthday=" + birthday +
                ", politicalstatus='" + politicalstatus + '\'' +
                ", education='" + education + '\'' +
                ", nativeplace='" + nativeplace + '\'' +
                ", idnumber='" + idnumber + '\'' +
                ", contactnumber='" + contactnumber + '\'' +
                ", basicsalary=" + basicsalary +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", departmentid=" + departmentid +
                ", position='" + position + '\'' +
                ", hiredate=" + hiredate +
                '}';
    }
}