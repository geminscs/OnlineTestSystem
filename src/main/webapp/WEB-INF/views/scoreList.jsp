<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>考试成绩</title>
     <script type="text/javascript">
    $("td").removeClass().addClass("text-center");
    $("th").removeClass().addClass("text-center");
    
    $("#returnScoreTestList").click(function(){
   	 	$("#content").load("/StuScore");
    });
    </script>
</head>
<body>
    <div align='center'>
        <table  cellspacing="10" class="table table-striped table-bordered text-center bootstrap-datatable datatable responsive">
            <caption>考试成绩</caption>
            <thead>
            <tr>
                <th>学生编号 </th>
                <th>用户名 </th>
                <th>选择题得分 </th>
                <th>判断题得分 </th>
                <th>简答题得分 </th>
                <th>总分 </th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="um">
            <tr>
                <td name="studentID">${um.getGrade().getStudentId() }</td>
                <td>${um.getStudent().getName() }</td>
                <td>${um.getGrade().getSelectGrade()}</td>
                <td>${um.getGrade().getJudgeGrade() }</td>
                <td><c:if test="${um.getGrade().getShortEssayGrade()<0 }">N/A</c:if> <c:if test="${um.getGrade().getShortEssayGrade()>=0 }">${um.getGrade().getShortEssayGrade()}</c:if></td>
                <td>${um.getGrade().getTotalGrade() }</td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>
        <button id="returnScoreTestList" class="btn btn-primary btn-xs" style="align:'center'">返回</button>
    </div>
    
</body>
</html>