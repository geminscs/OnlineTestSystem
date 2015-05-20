<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>批改试卷</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script src="javascripts/mark.js"></script>
</head>
<body>
    <input type="hidden" id="stuID" value="${studentId }">
    <input type="hidden" id="testID" value="${testId }">
    <div  align="center">
    		<% int order = 1; %>
			<c:forEach items="${list }" var="um">
            <div align="left"  name="question">
                <input type="hidden" id="questionID<%=order %>" value="${um.getTestQuestion().getId() }">
                <p><label><%=order %>.</label>${um.getTestQuestion().getContent() }</p>
                <p><label>参考答案：</label>${um.getTestQuestion().getAnsLong() }</p>
                <p><label>学生答案：</label>${um.getTestAnswer().getAnswer() }</p>
                <input type="hidden" id="value<%=order %>" value="${um.getTestQuestion().getValue() }">
                <label>得分：</label><input type="number" id="score<%=order %>" placeholder="输入0~${um.getTestQuestion().getValue() }" pattern="[0-${um.getTestQuestion().getValue() }]">
            </div>
            <% order ++; %>
            </c:forEach>
            <button id="submitScore" class="btn btn-primary btn-xs">提交</button>

    </div>
</body>
</html>