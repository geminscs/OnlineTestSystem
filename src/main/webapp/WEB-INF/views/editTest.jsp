<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <script src="javascripts/jquery-1.9.0.min.js"></script>
	
    <title></title>
    <script type="text/javascript">
    $("td").removeClass().addClass("text-center");
    $("th").removeClass().addClass("text-center");
    </script>
</head>
<body>
    <div align="center">

        <table class="table table-striped table-bordered text-center bootstrap-datatable datatable responsive">

            <caption>已有考试列表</caption>
            <thead>
            <tr>
                <th>考试编号 </th>
                <th>考试开始时间 </th>
                <th>考试结束时间 </th>
                <th>考试时长(min) </th>
                <th>编辑</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${testWrapper}" var="um">
            	<tr>
                	<td>${um.test.id }</td>
                	<td>${um.formatStartTime }</td>
                	<td>${um.formatEndTime }</td>
                	<td>${um.test.duration }</td>
                	<td><button name="edit" id="${um.test.id }" class="btn btn-primary btn-xs">编辑</button>
                    	<button name="delPaper" id="${um.test.id }" class="btn btn-primary btn-xs">删除</button>
                	</td>
           		 </tr>
            </c:forEach>
            <tr id="newTest">
                <td id="newTestID"> </td>
                <td><input id="startDate" type="date" name="startTime"><input id="startTime" type="time" name="startTime"></td>
                <td><input id="endDate" type="date" name="startTime"><input id="endTime" type="time" name="startTime"></td>
                <td><input id="duration" type="number" name="duration"></td>
                <td><button type="submit" id="addTest" class="btn btn-primary btn-xs">添加</button>
                </td>
            </tr>
            </tbody>
        </table>

    </div>
</body>
</html>