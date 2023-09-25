-- 创建数据库
DROP DATABASE IF EXISTS personnel;
CREATE DATABASE IF NOT EXISTS personnel;

-- 使用personnel数据库
USE personnel;

-- 禁用外键检查
SET FOREIGN_KEY_CHECKS = 0;

-- 员工表（Employee）
CREATE TABLE Employee
(
    EmployeeID      INT PRIMARY KEY AUTO_INCREMENT COMMENT '员工ID',
    Name            VARCHAR(50) COMMENT '姓名',
    Gender          VARCHAR(10) COMMENT '性别',
    Photo           VARCHAR(255) COMMENT '照片',
    Ethnicity       VARCHAR(50) COMMENT '民族',
    Birthday        DATE COMMENT '生日',
    PoliticalStatus VARCHAR(50) COMMENT '政治面貌',
    Education       VARCHAR(50) COMMENT '文化程度',
    NativePlace     VARCHAR(100) COMMENT '籍贯',
    IDNumber        VARCHAR(20) UNIQUE COMMENT '身份证号',
    ContactNumber   VARCHAR(20) COMMENT '联系电话',
    BasicSalary     DECIMAL(10, 2) COMMENT '基本工资',
    Username        VARCHAR(50) UNIQUE COMMENT '登录名称',
    Password        VARCHAR(50) COMMENT '密码',
    DepartmentID    INT COMMENT '部门ID',
    Position        VARCHAR(50) COMMENT '职位',
    HireDate        DATE COMMENT '入职日期',
    FOREIGN KEY (DepartmentID) REFERENCES Department (DepartmentID)
) COMMENT '员工表';

-- 部门表（Department）
CREATE TABLE Department
(
    DepartmentID       INT PRIMARY KEY AUTO_INCREMENT COMMENT '部门ID',
    DepartmentName     VARCHAR(50) UNIQUE COMMENT '部门名称',
    DepartmentFunction VARCHAR(100) COMMENT '部门职能',
    ParentDepartmentID INT COMMENT '上级部门ID',
    FOREIGN KEY (ParentDepartmentID) REFERENCES Department (DepartmentID)
) COMMENT '部门表';

-- 休假信息表（Leave）
CREATE TABLE `Leave`
(
    LeaveID    INT PRIMARY KEY AUTO_INCREMENT COMMENT '休假ID',
    EmployeeID INT COMMENT '员工ID',
    LeaveType  VARCHAR(50) COMMENT '休假类型',
    StartDate  DATE COMMENT '休假开始日期',
    EndDate    DATE COMMENT '休假结束日期',
    FOREIGN KEY (EmployeeID) REFERENCES Employee (EmployeeID)
) COMMENT '休假信息表';

-- 事件日志表（EventLog）
CREATE TABLE EventLog
(
    LogID       INT PRIMARY KEY AUTO_INCREMENT COMMENT '日志ID',
    UserID      INT COMMENT '用户ID',
    EventType   VARCHAR(50) COMMENT '事件类型',
    Timestamp   TIMESTAMP COMMENT '时间戳',
    Description VARCHAR(255) COMMENT '事件描述',
    Remarks     VARCHAR(255) COMMENT '备注'
) COMMENT '事件日志表';

-- 考勤规则表（AttendanceRules）
CREATE TABLE AttendanceRules
(
    id                INT PRIMARY KEY AUTO_INCREMENT COMMENT '规则ID',
    name              VARCHAR(50) NOT NULL COMMENT '规则名称',
    startTime         TIME        NOT NULL COMMENT '上班时间',
    endTime           TIME        NOT NULL COMMENT '下班时间',
    workDays          VARCHAR(20) NOT NULL COMMENT '工作日',
    lateThreshold     INT COMMENT '迟到阈值（分钟）',
    earlyThreshold    INT COMMENT '早退阈值（分钟）',
    overtimeAllowed   TINYINT(1)  NOT NULL COMMENT '是否允许加班',
    overtimeStartTime TIME COMMENT '加班开始时间',
    overtimeEndTime   TIME COMMENT '加班结束时间'
) COMMENT ='考勤规则表';


-- 考勤记录表（Attendance）
CREATE TABLE Attendance
(
    RecordID   INT PRIMARY KEY AUTO_INCREMENT COMMENT '记录ID',
    EmployeeID INT COMMENT '员工ID',
    Date       DATE COMMENT '日期',
    StartTime  TIME COMMENT '上班时间',
    EndTime    TIME COMMENT '下班时间',
    FOREIGN KEY (EmployeeID) REFERENCES Employee (EmployeeID)
) COMMENT '考勤记录表';

-- 加班信息表（Overtime）
CREATE TABLE Overtime
(
    OvertimeID       INT PRIMARY KEY AUTO_INCREMENT COMMENT '加班ID',
    EmployeeID       INT COMMENT '员工ID',
    OvertimeDate     DATE COMMENT '加班日期',
    OvertimeDuration DECIMAL(5, 2) COMMENT '加班时长',
    FOREIGN KEY (EmployeeID) REFERENCES Employee (EmployeeID)
) COMMENT '加班信息表';

-- 工资记录表（Salary）
CREATE TABLE Salary
(
    RecordID       INT PRIMARY KEY AUTO_INCREMENT COMMENT '记录ID',
    EmployeeID     INT COMMENT '员工ID',
    PaymentDate    DATE COMMENT '发放日期',
    BasicSalary    DECIMAL(10, 2) COMMENT '基本工资',
    OvertimeSalary DECIMAL(10, 2) COMMENT '加班工资',
    Bonus          DECIMAL(10, 2) COMMENT '奖金',
    Deduction      DECIMAL(10, 2) COMMENT '扣除',
    NetSalary      DECIMAL(10, 2) COMMENT '最终工资',
    FOREIGN KEY (EmployeeID) REFERENCES Employee (EmployeeID)
) COMMENT '工资记录表';

-- 报表表（Report）
CREATE TABLE Report
(
    ReportID      INT PRIMARY KEY AUTO_INCREMENT COMMENT '报表ID',
    ReportName    VARCHAR(50) COMMENT '报表名称',
    ReportType    VARCHAR(50) COMMENT '报表类型',
    ReportContent TEXT COMMENT '报表内容'
) COMMENT '报表表';

-- 管理员表（Admin）
CREATE TABLE Admin
(
    AdminID       INT PRIMARY KEY AUTO_INCREMENT COMMENT '管理员ID',
    Name          VARCHAR(50) COMMENT '姓名',
    Gender        VARCHAR(10) COMMENT '性别',
    Photo         VARCHAR(255) COMMENT '照片',
    ContactNumber VARCHAR(20) COMMENT '联系电话',
    Username      VARCHAR(50) UNIQUE COMMENT '登录名称',
    Password      VARCHAR(50) COMMENT '密码'
) COMMENT ='管理员表';

-- 启用外键检查
SET FOREIGN_KEY_CHECKS = 1;