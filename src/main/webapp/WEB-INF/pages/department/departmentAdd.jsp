<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <meta charset="utf-8">
    <title>新部门</title>
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
        <label class="layui-form-label required">部门名称</label>
        <div class="layui-input-block">
            <input type="text" name="departmentname" lay-verify="required" lay-reqtext="部门名称不能为空"
                   placeholder="请输入部门名称" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">部门职能</label>
        <div class="layui-input-block">
            <input type="text" name="departmentfunction" lay-verify="required" lay-reqtext="部门职能不能为空"
                   placeholder="请输入部门职能" autocomplete="off" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label">上级部门ID</label>
        <div class="layui-input-block">
            <input type="number" name="parentdepartmentid" autocomplete="off" class="layui-input">
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
    layui.use(['form', 'laydate'], function () {
        var form = layui.form,
            layer = layui.layer,
            laydate = layui.laydate,
            $ = layui.$;

        //日期
        laydate.render({
            elem: '#date',
            trigger: 'click'
        });

        // //动态获取图书类型的数据
        // $.get("findAllList",{},function (data) {
        //     var list=data;
        //     var select=document.getElementById("typeId");
        //     if(list!=null|| list.size()>0){
        //         for(var c in list){
        //             var option=document.createElement("option");
        //             option.setAttribute("value",list[c].id);
        //             option.innerText=list[c].name;
        //             select.appendChild(option);
        //         }
        //     }
        //     form.render('select');
        // },"json")

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            var datas = data.field;//form单中的数据信息
            //向后台发送数据提交添加
            $.ajax({
                url: "addDepartmentSubmit",
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

