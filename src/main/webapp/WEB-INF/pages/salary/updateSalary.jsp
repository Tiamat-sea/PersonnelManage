<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <title>修改图书</title>
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
    <input type="hidden" name="recordid" value="${salary.recordid}">

    <div class="layui-form-item">
        <label class="layui-form-label required">工号</label>
        <div class="layui-input-block">
            <input type="text" name="employeeid" value="${salary.employeeid}" lay-verify="required" lay-reqtext=""
                   placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">发放日期</label>
        <div class="layui-input-block">
            <input type="text" name="paymentdate"
                   value="<fmt:formatDate value="${salary.paymentdate}" pattern="yyyy-MM-dd"/>"
                   id="paymentdate" lay-verify="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">基本工资</label>
        <div class="layui-input-block">
            <input type="text" name="basicsalary" value="${salary.basicsalary}" lay-verify="required" lay-reqtext=""
                   placeholder="" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">加班工资</label>
        <div class="layui-input-block">
            <input type="text" name="overtimesalary" value="${salary.overtimesalary}" lay-verify="required" class="layui-input" autocomplete="off">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">奖金</label>
        <div class="layui-input-block">
            <input type="text" name="bonus" lay-verify="required" value="${salary.bonus}" class="layui-input" autocomplete="off">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">扣除</label>
        <div class="layui-input-block">
            <input type="text" name="deduction" value="${salary.deduction}" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">最终工资</label>
        <div class="layui-input-block">
            <input type="number" name="netsalary" value="${salary.netsalary}" autocomplete="off" class="layui-input">
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
            elem: '#paymentdate',
            trigger: 'click'
        });

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas = data.field;//form单中的数据信息
            //向后台发送数据提交添加
            $.ajax({
                url: "updateSalarySubmit",
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

