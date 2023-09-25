<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%--<%
    String path=request.getContextPath();
    String basePath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>--%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>员工管理</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/public.css" media="all">
    <script src="${pageContext.request.contextPath}/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <div class="demoTable">
            <div class="layui-form-item layui-form ">
                工号：
                <div class="layui-inline">
                    <input class="layui-input" name="employeeid" id="employeeid" autocomplete="off">
                </div>
                姓名：
                <div class="layui-inline">
                    <input class="layui-input" name="name" id="name" autocomplete="off">
                </div>
                部门：
                <div class="layui-inline">
                    <select id="departmentid" name="departmentid" lay-verify="required">
                        <option value="">请选择</option>
                    </select>
                </div>
                <button class="layui-btn" data-type="reload">搜索</button>
            </div>
        </div>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 新员工</button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 炒鱿鱼
                </button>
            </div>
        </script>

        <!--表单，查询出的数据在这里显示-->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="update">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">炒鱿鱼</a>
        </script>

    </div>
</div>

<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        //动态获取部门的数据，下拉菜单，跳出部门
        $.get("findAllDepartment", {}, function (data) {
            var list = data;
            var select = document.getElementById("departmentid");
            if (list != null || list.size() > 0) {
                for (var obj in list) {
                    var option = document.createElement("option");
                    option.setAttribute("value", list[obj].departmentid);
                    option.innerText = list[obj].departmentname;
                    select.appendChild(option);
                }
            }
            form.render('select');
        }, "json")

        table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/employeeAll',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [
                [
                    {type: "checkbox", fixed: 'left', width: 50},
                    {field: 'employeeid', width: 80, fixed: 'left', title: '工号', sort: true},
                    {field: 'name', width: 100, title: '姓名'},
                    {field: 'gender', width: 80, title: '性别'},
                    // { field: 'photo', width: 100, title: '照片' },
                    // { field: 'ethnicity', width: 80, title: '民族' },
                    {field: 'birthday', width: 120, title: '出生日期'},
                    {field: 'politicalstatus', width: 120, title: '政治面貌'},
                    {field: 'education', width: 80, title: '学历'},
                    {field: 'nativeplace', width: 80, title: '籍贯'},
                    // { field: 'idnumber', width: 80, title: '身份证号' },
                    {field: 'contactnumber', width: 120, title: '联系电话'},
                    {field: 'basicsalary', width: 100, title: '基本工资'},
                    // { field: 'username', width: 80, title: '登录名称' },
                    {
                        field: 'department',
                        width: 100,
                        title: '部门',
                        templet: "<div>{{ d.department.departmentname }}</div>"
                    },
                    {field: 'position', width: 80, title: '职位'},
                    {title: '操作', fixed: 'right', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
                ]
            ],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 100,
            page: true,
            skin: 'line',
            id: 'testReload'
        });

        var $ = layui.$, active = {
            reload: function () {
                var employeeid = $('#employeeid').val();
                var name = $('#name').val();
                var departmentid = $('#departmentid').val();
                // console.log(name)
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        employeeid: employeeid,
                        name: name,
                        departmentid: departmentid
                    }
                }, 'data');
            }
        };

        $('.demoTable .layui-btn').on('click', function () {
            var type = $(this).data('type');
            active[type] ? active[type].call(this) : '';
        });

        /**
         * tool操作栏监听事件
         */
        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'update') {  // 监听修改操作
                var index = layer.open({
                    title: '修改员工信息',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['50%', '95%'],
                    content: '${pageContext.request.contextPath}/queryEmployeeById?id=' + data.employeeid,
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                layer.confirm('确定是否删除', function (index) {
                    //调用删除功能
                    deleteInfoByIds(data.employeeid, index);
                    layer.close(index);
                });
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        /**
         * 获取选中记录的id信息
         */
        function getCheackId(data) {
            var arr = [];
            for (var i = 0; i < data.length; i++) {
                arr.push(data[i].employeeid);
            }
            //拼接id,变成一个字符串
            return arr.join(",");
        }


        /**
         * 提交删除功能
         */
        function deleteInfoByIds(ids, index) {
            //向后台发送请求
            $.ajax({
                url: "deleteEmployee",
                type: "POST",
                data: {ids: ids},
                success: function (result) {
                    if (result.code == 0) {//如果成功
                        layer.msg('删除成功', {
                            icon: 6,
                            time: 500
                        }, function () {
                            parent.window.location.reload();
                            var iframeIndex = parent.layer.getFrameIndex(window.name);
                            parent.layer.close(iframeIndex);
                        });
                    } else {
                        layer.msg("删除失败");
                    }
                }
            })
        }

        /**
         * toolbar栏监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '新员工',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['50%', '95%'],
                    content: '${pageContext.request.contextPath}/employeeAdd',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {
                /*
                  1、提示内容，必须删除大于0条
                  2、获取要删除记录的id信息
                  3、提交删除功能 ajax
                */
                //获取选中的记录信息
                var checkStatus = table.checkStatus(obj.config.id);
                var data = checkStatus.data;
                console.log(data)
                if (data.length == 0) {//如果没有选中信息
                    layer.msg("请选择要删除的记录信息");
                } else {
                    //获取记录信息的id集合,拼接的ids
                    var ids = getCheackId(data);
                    layer.confirm('确定是否删除', function (index) {
                        //调用删除功能
                        deleteInfoByIds(ids, index);
                        layer.close(index);
                    });
                }
            }
        });

    });
</script>

</body>
</html>
