<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>

    <script src="javascripts/stuInfo.js"></script>
    <title>考生信息管理</title>
</head>
<body>
    <div align="center">

        <table cellspacing="10"  style="text-align: center" class="table table-striped table-bordered text-center bootstrap-datatable datatable responsive">

            <caption>考生信息</caption>
            <thead>
            <tr>
                <th>考生编号</th>
                <th>用户名</th>
                <th>编辑</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="um">
            <tr>
                <td name="stuID">${um.getAccount() }</td>
                <td>${um.getName() }</td>
                <td><button  name="delStu" class="btn btn-primary btn-xs">删除</button></td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>