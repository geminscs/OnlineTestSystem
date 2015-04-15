<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <script src="javascripts/jquery-1.9.0.min.js"></script>
	
    <title></title>
</head>
<body>
    <div align="center">

        <table  class="table table-striped table-bordered text-center bootstrap-datatable datatable responsive">

            <caption>可参加考试列表</caption>
            <thead>
            <tr >
                <th class="text-center">考试编号 </th>
                <th class="text-center">考试开始时间 </th>
                <th class="text-center">考试结束时间 </th>
                <th class="text-center">考试时长(min) </th>
                <th> </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${testWrapper}" var="um">
            	<tr>
                <td class="text-center">${um.test.id}</td>
                <td class="text-center">${um.formatStartTime }</td>
                <td class="text-center">${um.formatEndTime }</td>
                <td class="text-center">${um.test.duration }</td>
                <td class="text-center"><button name="startTest" id="${um.test.id}"  class="btn btn-primary btn-xs">开始考试</button>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>