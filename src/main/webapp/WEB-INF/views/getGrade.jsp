<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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

        <table class="table table-striped table-bordered text-center bootstrap-datatable datatable responsive">

            <caption>成绩列表</caption>
            <thead>
            <tr>
                <th class="text-center">考试编号 </th>
                <th class="text-center">考试开始时间 </th>
                <th class="text-center">考试结束时间 </th>
                <th class="text-center">选择题成绩 </th>
                <th class="text-center">判断题成绩</th>
                <th class="text-center">简答题成绩</th>
                <th class="text-center">总成绩</th>
                
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list}" var="um">
            	<tr>
                <td class="text-center">${um.getGrade().getTestId() }</td>
                <td class="text-center">${um.getFormatStartTime() } </td>
                <td class="text-center">${um.getFormatEndTime() } </td>
                <td class="text-center">${um.getGrade().getSelectGrade()} </td>
                <td class="text-center">${um.getGrade().getJudgeGrade() } </td>
                <td class="text-center"><c:if test="${um.getGrade().getShortEssayGrade()<0 }">N/A</c:if> <c:if test="${um.getGrade().getShortEssayGrade()>=0 }">${um.getGrade().getShortEssayGrade()}</c:if></td>
                <td class="text-center">${um.getGrade().getTotalGrade() } </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>