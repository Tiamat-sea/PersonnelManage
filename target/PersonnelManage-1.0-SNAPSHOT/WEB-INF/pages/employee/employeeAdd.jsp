<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>新员工</title>
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
    <div class="layui-form-item">
        <label class="layui-form-label required">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">性别</label>
        <div class="layui-input-block">
            <select name="gender" id="" lay-verify="" class="layui-input">
                <option value="">请选择</option>
                <option value="男">男</option>
                <option value="女">女</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">照片</label>
        <div class="layui-input-block">
            <input type="text" name="photo" placeholder="请上传照片" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">民族</label>
        <div class="layui-input-block">
            <input type="text" name="ethnicity" placeholder="请输入民族" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">出生日期</label>
        <div class="layui-input-block">
            <input type="text" name="birthday" id="birthday" lay-verify="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">政治面貌</label>
        <div class="layui-input-block">
            <input type="text" name="politicalstatus" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">文化程度</label>
        <div class="layui-input-block">
            <input type="text" name="education" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">籍贯</label>
        <div class="layui-input-block">
            <input type="text" name="nativeplace" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">身份证号</label>
        <div class="layui-input-block">
            <input type="text" name="idnumber" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">联系电话</label>
        <div class="layui-input-block">
            <input type="text" name="contactnumber" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">基本工资</label>
        <div class="layui-input-block">
            <input type="text" name="basicsalary" lay-verify="number" id="basicsalaryInput" autocomplete="off"
                   class="layui-input">
        </div>
    </div>


    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">登录名称</label>
        <div class="layui-input-block">
            <input type="text" name="username" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-block">
            <input type="text" name="password" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">所属部门</label>
        <div class="layui-input-block">
            <select name="departmentid" id="departmentid" lay-verify="required">
                <option value="">请选择</option>
            </select>
        </div>
    </div>

    <div class="layui-form-item layui-form-text">
        <label class="layui-form-label">职位</label>
        <div class="layui-input-block">
            <input type="text" name="position" placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">入职日期</label>
        <div class="layui-input-block">
            <input type="text" name="hiredate" id="hiredate" lay-verify="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layer', 'laydate'], function () {
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

        // 动态获取部门数据
        $.get("findAllDepartment", {}, function (data) {
            var list = data;
            var select = document.getElementById("departmentid");
            if (list != null || list.size() > 0) {
                for (var c in list) {
                    var option = document.createElement("option");
                    option.setAttribute("value", list[c].departmentid);
                    option.innerText = list[c].departmentname;
                    select.appendChild(option);
                }
            }
            form.render('select');
        }, "json")

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas = data.field;//form单中的数据信息
            // // 将基本工资转换为BigDecimal类型
            // datas.basicsalary = parseFloat(datas.basicsalary);
            // // 将日期转换为Date类型
            // datas.birthday = new Date(datas.birthday);
            // datas.hiredate = new Date(datas.hiredate);

            console.log(datas); // 打印表单数据到控制台
            //向后台发送数据提交添加
            $.ajax({
                url: "addEmployeeSubmit",
                type: "POST",
                data: datas,
                success: function (result) {
                    if (result.code == 0) {//如果成功
                        layer.msg('添加成功', {
                            icon: 6,
                            time: 500
                        }, function () {
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        })
                    } else {
                        layer.msg("添加失败");
                    }
                }
            })
            return false;
        });
    });
</script>
</body>
</html>

