<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Quick Start - Layui</title>
    <link href="/cdn.staticfile.org/layui/2.8.0/css/layui.css" rel="stylesheet">
</head>
<body>
<!-- HTML Content -->
<script src="/cdn.staticfile.org/layui/2.8.0/layui.js"></script>
<script>
    // Usage
    layui.use(function () {
        var layer = layui.layer;
        // Welcome
        layer.msg('欢迎使用人事管理系统', {icon: 6});
    });
</script>
</body>
</html>