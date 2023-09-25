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
    <title>部门管理</title>
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
                名称：
                <div class="layui-inline">
                    <input class="layui-input" name="departmentname" id="departmentname" autocomplete="off">
                </div>
                <button class="layui-btn" data-type="reload">搜索</button>
            </div>
        </div>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 新部门</button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 解散
                </button>
            </div>
        </script>

        <!--表单，查询出的数据在这里显示-->
        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="update">修改</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">解散</a>
        </script>

        <blockquote class="layui-elem-quote layui-text">
            温馨提示：解散部门需先将该部门下的员工调离！
        </blockquote>
    </div>

    <hr class="layui-border-green">
    <div id="departmentTreeView"></div>
</div>

<script>
    layui.use(['form', 'table', 'tree', 'layer'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: '${pageContext.request.contextPath}/departmentAll',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", fixed: 'left', width: 50},
                {field: 'departmentid', fixed: 'left', width: 100, title: '编号', sort: true},
                {field: 'departmentname', width: 300, title: '名称'},
                {field: 'departmentfunction', width: 300, title: '职能'},
                {field: 'parentdepartmentid', width: 100, title: '上级部门'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 100,  <!--默认显示15条-->
            page: true,
            // totalRow: true, // 开启合计行
            skin: 'line',
            id: 'testReload'
        });

        <%--$.get("${pageContext.request.contextPath}/departmentAll", {}, function transformData(data) {--%>
        <%--    // 创建一个空对象，用于存储构建后的树形结构--%>
        <%--    let tree = {};--%>

        <%--    // 创建一个辅助对象，用于快速查找部门--%>
        <%--    let departmentMap = {};--%>

        <%--    // 遍历原始数据，将每个部门对象存储到辅助对象中--%>
        <%--    for (let i = 0; i < data.length; i++) {--%>
        <%--        let department = data[i];--%>
        <%--        departmentMap[department.departmentid] = department;--%>
        <%--    }--%>

        <%--    // 遍历原始数据，根据父级部门ID构建树形结构--%>
        <%--    for (let i = 0; i < data.length; i++) {--%>
        <%--        let department = data[i];--%>

        <%--        // 如果部门没有父级部门ID，则将其作为根节点--%>
        <%--        if (!department.parentdepartmentid) {--%>
        <%--            tree.title = department.departmentname;--%>
        <%--            tree.id = department.departmentid;--%>
        <%--            tree.children = [];--%>
        <%--        } else {--%>
        <%--            // 否则，将部门添加到对应父级部门的children数组中--%>
        <%--            let parent = departmentMap[department.parentdepartmentid];--%>
        <%--            if (parent) {--%>
        <%--                if (!parent.children) {--%>
        <%--                    parent.children = [];--%>
        <%--                }--%>
        <%--                parent.children.push({--%>
        <%--                    title: department.departmentname,--%>
        <%--                    id: department.departmentid--%>
        <%--                });--%>
        <%--            }--%>
        <%--        }--%>
        <%--    }--%>
        <%--    console.log(tree);--%>
        <%--    return [tree]; // 返回一个包含根节点的数组，以匹配目标数据结构--%>
        <%--},"json");--%>

        // var tree = layui.tree;
        // var layer = layui.layer;
        // // 模拟数据
        // var data = [{title:'江西',id:1,children:[{title:'南昌',id:1000,children:[{title:'青山湖区',id:10001},{title:'高新区',id:10002}]},{title:'九江',id:1001},{title:'赣州',id:1002}]},{title:'广西',id:2,children:[{title:'南宁',id:2000},{title:'桂林',id:2001}]},{title:'陕西',id:3,children:[{title:'西安',id:3000},{title:'延安',id:3001}]},{title:'山西',id:3,children:[{title:'太原',id:4000},{title:'长治',id:4001}]}];
        // // 渲染
        // tree.render({
        //     elem: '#departmentTreeView',
        //     data: data,
        //     onlyIconControl: true,  // 是否仅允许节点左侧图标控制展开收缩
        //     click: function(obj){
        //         layer.msg(JSON.stringify(obj.data));
        //     }
        // });

        var $ = layui.$, active = {
            reload: function () {
                var departmentname = $('#departmentname').val();
                console.log(name)
                //执行重载
                table.reload('testReload', {
                    page: {
                        curr: 1 //重新从第 1 页开始
                    }
                    , where: {
                        departmentname: departmentname
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
                    title: '修改部门信息',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['50%', '90%'],
                    content: '${pageContext.request.contextPath}/queryDepartmentById?id=' + data.departmentid,
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                layer.confirm('真的要删除咩？', function (index) {
                    //调用删除功能
                    deleteInfoByIds(data.departmentid, index);
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
                arr.push(data[i].departmentid);
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
                url: "deleteDepartment",
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
                    title: '新部门',
                    type: 2,
                    shade: 0.2,
                    maxmin: true,
                    shadeClose: true,
                    area: ['50%', '90%'],
                    content: '${pageContext.request.contextPath}/departmentAdd',
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
                if (data.length == 0) {//如果没有选中信息
                    layer.msg("你都没选让我怎么删？");
                } else {
                    //获取记录信息的id集合,拼接的ids
                    var ids = getCheackId(data);
                    layer.confirm('真的要解散咩？', function (index) {
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
