<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <meta charset="utf-8">
    <title>修改规则</title>
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
    <input type="hidden" name="id" value="${attendanceRules.id}">

    <div class="layui-form-item">
        <label class="layui-form-label required">名称</label>
        <div class="layui-input-block">
            <input type="text" name="name" value="${attendanceRules.name}" lay-verify="required"
                   lay-reqtext="名称不能为空" placeholder="请输入名称" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">上班时间</label>
        <div class="layui-input-block">
            <input type="text" name="starttime" value="${attendanceRules.starttime}" class="layui-input" id="starttime"
                   placeholder="HH:mm:ss">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">下班时间</label>
        <div class="layui-input-block">
            <input type="text" name="endtime" value="${attendanceRules.endtime}" class="layui-input" id="endtime"
                   placeholder="HH:mm:ss">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">工作日</label>
        <div class="layui-input-block">
            <input type="text" name="workdays" value="${attendanceRules.workdays}" lay-verify="required"
                   class="layui-input" autocomplete="off">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">迟到阈值（分钟）</label>
        <div class="layui-input-block">
            <input type="text" name="latethreshold" value="${attendanceRules.latethreshold}" lay-verify="required"
                   class="layui-input" autocomplete="off">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">早退阈值（分钟）</label>
        <div class="layui-input-block">
            <input type="text" name="earlythreshold" value="${attendanceRules.earlythreshold}" autocomplete="off"
                   class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">是否允许加班</label>
        <div class="layui-input-block">
            <input type="text" name="overtimeallowed" value="${attendanceRules.overtimeallowed}"
                   placeholder="1：是  0：否" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">加班开始时间</label>
        <div class="layui-input-block">
            <input type="text" name="overtimestarttime" id="ostarttime" value="${attendanceRules.overtimestarttime}"
                   autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">加班结束时间</label>
        <div class="layui-input-block">
            <input type="text" name="overtimeendtime" id="oendtime" value="${attendanceRules.overtimeendtime}"
                   autocomplete="off" class="layui-input">
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
        // laydate.render({
        //     elem: '#date',
        //     trigger:'click'
        // });

        // 时间选择器
        laydate.render({
            elem: '#starttime',
            type: 'time'
        });

        laydate.render({
            elem: '#endtime',
            type: 'time'
        });

        laydate.render({
            elem: '#ostarttime',
            type: 'time'
        });

        laydate.render({
            elem: '#oendtime',
            type: 'time'
        });

        // //动态获取图书类型的数据
        // $.get("findAllList",{},function (data) {
        //     //获取图书类型的值
        //     var typeId=$('#typeId')[0].value;
        //     var list=data;
        //     var select=document.getElementById("typeId");
        //     if(list!=null|| list.size()>0){
        //         for(var c in list){
        //             var option=document.createElement("option");
        //             option.setAttribute("value",list[c].id);
        //             option.innerText=list[c].name;
        //             select.appendChild(option);
        //             //如果类型和循环到的类型iD一致，选中
        //             if (list[c].id==typeId){
        //                 option.setAttribute("selected","selected");
        //                 layui.form.render('select');
        //             }
        //         }
        //     }
        //     form.render('select');
        // },"json")

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas = data.field;//form单中的数据信息
            //向后台发送数据提交添加
            $.ajax({
                url: "updateAttendanceRulesSubmit",
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

