<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
  <header>
    <title>test</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script type="text/javascript" src="javascripts/testTimeControl.js"></script>
  </header>

<body bgcolor="#cccccc">
    <div id="time"><input type="hidden"  id="duration" value="${testWrapper.test.duration }"><label>剩余时间：</label><span id="min"></span>:<span id="sec"></span></div>
	<input type="hidden" id="testID" value="${testWrapper.test.id }">
	<div id="testPaper">
		<div id="select">
		<% int order = 1; %>
			<h4>一、选择题</h4>
			<c:forEach items="${testQuestionType0 }" var="um">
				<form class="selectQuestion" action="">
					<p><%=order %>.${um.content }</p>
					<input type="hidden" id="selectID<%=order %>" value="${um.id}">
					<input type="radio" name="selectAnswer<%=order %>" value="0">A.${um.ansA }
					<br/>
					<input type="radio" name="selectAnswer<%=order %>" value="1">B.${um.ansB }
					<br/>
					<input type="radio" name="selectAnswer<%=order %>" value="2">C.${um.ansC }
					<br/>
					<input type="radio" name="selectAnswer<%=order %>" value="3">D.${um.ansD }
					<br/><br/>
				</form>
				<% order ++; %>
			</c:forEach>
			
		</div>
		<div id="judge">
		<% order = 1; %>
			<h4>二、判断题</h4>
			<c:forEach items="${testQuestionType1 }" var="um">
				<form class="judgeQuestion" action="">
					<p><%=order %>.${um.content }</p>
					<input type="hidden" id="judgeID<%=order %>" value="${um.id }">
					<input type="radio" name="judgeAnswer<%=order %>" value="0">错误
					<input type="radio" name="judgeAnswer<%=order %>" value="1">正确
					<br/><br/>
				</form>
				<% order ++; %>
			</c:forEach>
		</div>
		<div id="shortAnswer">
		<% order = 1; %>
			<h4>三、简答题</h4>
			<c:forEach items="${testQuestionType2 }" var="um">
				<form class="shortQuestion" action="">
					<p><%=order %>.${um.content }</p>
					<input type="hidden" id="shortID<%=order %>" value="${um.id }">
					<textarea  rows="5" cols="100" name="shortAnswer<%=order %>"></textarea>
					<br/><br/>
				</form>
			</c:forEach>
		</div>
		<br/><br/>
		<div id="handle" align="center">
			<button id="submit"  class="btn btn-primary btn-xs">提交</button>
			<button id="reset"  class="btn btn-primary btn-xs">重置</button>
		</div>
	</div>
</body>
</html>