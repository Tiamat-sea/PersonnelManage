<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <title>修改</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <input type="hidden" name="employeeid" value="${employee.employeeid}">
    <div class="layui-form-item">
        <label class="layui-form-label required">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" value="${employee.name}" lay-verify="required" lay-reqtext="姓名不能为空"
                   placeholder="请输入姓名" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">性别</label>
        <div class="layui-input-block">
            <select name="gender" id="" lay-verify="">
                <option value="${employee.gender}">${employee.gender}</option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">照片</label>
        <div class="layui-input-block">
            <input type="text" name="photo" value="${employee.photo}" placeholder="请上传照片" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">民族</label>
        <div class="layui-input-block">
            <input type="text" name="ethnicity" value="${employee.ethnicity}" placeholder="请输入民族"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出生日期</label>
        <div class="layui-input-block">
            <input type="text" name="birthday"
                   value="<fmt:formatDate value="${employee.birthday}" pattern="yyyy-MM-dd"/>" id="birthday"
                   lay-verify="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">政治面貌</label>
        <div class="layui-input-block">
            <input type="text" name="politicalstatus" value="${employee.politicalstatus}" placeholder=""
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文化程度</label>
        <div class="layui-input-block">
            <input type="text" name="education" value="${employee.education}" placeholder="" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">籍贯</label>
        <div class="layui-input-block">
            <input type="text" name="nativeplace" value="${employee.nativeplace}" placeholder="" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-block">
            <input type="text" name="idnumber" value="${employee.idnumber}" placeholder="" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-block">
            <input type="text" name="contactnumber" value="${employee.contactnumber}" placeholder="" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">基本工资</label>
        <div class="layui-input-block">
            <input type="text" name="basicsalary" value="${employee.basicsalary}" lay-verify="number"
                   id="basicsalaryInput" autocomplete="off" class="layui-input">
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">登录名称</label>
        <div class="layui-input-block">
            <input type="text" name="username" value="${employee.username}" placeholder="" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" value="${employee.password}" placeholder="" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">所属部门</label>
        <div class="layui-input-block">
            <select name="departmentid" id="departmentid" lay-verify="required">
                <option value="${employee.departmentid}">${employee.department.departmentname}</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">职位</label>
        <div class="layui-input-block">
            <input type="text" name="position" value="${employee.position}" placeholder="" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">入职日期</label>
        <div class="layui-input-block">
            <input type="text" name="hiredate"
                   value="<fmt:formatDate value="${employee.hiredate}" pattern="yyyy-MM-dd"/>" id="hiredate"
                   lay-verify="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认修改</button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            laydate = layui.laydate,
            $ = layui.$;

        //日期
        laydate.render({
            elem: '#hiredate',
            trigger: 'click'
        });

        laydate.render({
            elem: '#birthday',
            trigger: 'click'
        });

        //动态获取部门数据
        $.get("findAllDepartment", {}, function (data) {
            var departmentid = $('#departmentid').val();
            var list = data;
            var select = document.getElementById("departmentid");
            if (list != null && list.length > 0) {
                for (var department of list) {
                    var option = document.createElement("option");
                    option.value = department.departmentid;
                    option.innerText = department.departmentname;
                    // 如果部门和循环到的部门id一致，选中
                    if (department.departmentid === departmentid) {
                        console.log(department.departmentid);
                        console.log(departmentid);
                        option.selected = true;
                    }
                    select.appendChild(option);
                }
            }
            layui.form.render('select');
        }, "json");


        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas = data.field;//form单中的数据信息
            // 将基本工资转换为BigDecimal类型
            datas.basicsalary = parseFloat(datas.basicsalary);
            // 将日期转换为Date类型
            datas.birthday = new Date(datas.birthday);
            datas.hiredate = new Date(datas.hiredate);
            //向后台发送数据提交更新
            $.ajax({
                url: "updateEmployeeSubmit",
                type: "POST",
                // data:datas,
                contentType: 'application/json',
                data: JSON.stringify(datas),
                success: function (result) {
                    if (result.code == 0) {//如果成功
                        layer.msg('修改成功', {
                            icon: 6,
                            time: 500
                        }, function () {
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    } else {
                        layer.msg("修改失败");
                    }
                }
            })
            return false;
        });
    });
</script>
</body>
</html>

