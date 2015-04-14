<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <script src="javascripts/jquery-1.9.0.min.js"></script>
    <script type="text/javascript" src="javascripts/editPaper.js"></script>
    <title></title>
</head>
<body>
    <div id="paper">
        <div id="title">
            <label>试卷ID:${testWrapper.test.id } </label>
            <input type="hidden" id="testID" value="${testWrapper.test.id }">
            <br/>
            开始时间:<input type="date" id="startDate" value="${testWrapper.getStartDate()}"><input type="time" id="startTime" value="${testWrapper.getStartTime()}">
            结束时间:<input type="date" id="endDate" value="${testWrapper.getEndDate()}"><input type="time" id="endTime" value="${testWrapper.getEndTime()}">
            考试时长:<input type="number" id="duration" value="${testWrapper.test.duration }">
        </div>
        <div id="content">
            <div id="selectQuestion">
                <h4>一、选择题</h4>
                <input type="hidden" id="maxSelectID" value="${testQuestionsType0.size()}">
                <% int order = 1; %>
               <c:forEach items="${testQuestionsType0}" var = "um">
                <div id="select<%=order %>">
                    <label id="selectID<%=order %>"><%=order %></label>.
                    <textarea id="selectContent<%=order %>" cols="100" rows="3"  style="vertical-align: top;">${um.content }</textarea>
                    <br/><br/>
                    <input type="radio" name="selectAnswer<%=order %>" value="0" <c:if test="${um.ansShort==0}">checked</c:if> >A.<input type="text" id="select<%=order %>option0" value = "${um.ansA}" >
                    <br/>
                    <input type="radio" name="selectAnswer<%=order %>" value="1" <c:if test="${um.ansShort==1}">checked</c:if> >B.<input type="text" id="select<%=order %>option1" value = "${um.ansB}" >
                    <br/>
                    <input type="radio" name="selectAnswer<%=order %>" value="2" <c:if test="${um.ansShort==2}">checked</c:if> >C.<input type="text" id="select<%=order %>option2" value = "${um.ansC}" >
                    <br/>
                    <input type="radio" name="selectAnswer<%=order %>" value="3"<c:if test="${um.ansShort==3}">checked</c:if>  >D.<input type="text" id="select<%=order %>option3" value = "${um.ansD}" >
                    <br/><br/>
                </div>
               <% order ++; %>
               </c:forEach>
                <button id="addSelect" class="btn btn-primary btn-xs">添加</button>
            </div>
            <% order = 1; %>
            <div id="judgeQuestion">
                <h4>二、判断题</h4>
                <input type="hidden" id="maxJudgeID" value="${testQuestionsType1.size()}">
                <c:forEach items="${testQuestionsType1}" var="um">
                <div id="judge<%=order %>">
                    <label id="judgeID@y.order"><%=order %></label>.
                    <textarea id="judgeContent<%=order %>" cols="100" rows="1"  style="vertical-align: top;">${um.content}</textarea>
                    <br/><br/>
                    <input type="radio" name="judgeAnswer<%=order %>" value="0" <c:if test="${um.ansShort==0}">checked</c:if> >错误
                    <input type="radio" name="judgeAnswer<%=order %>" value="1" <c:if test="${um.ansShort==1}">checked</c:if> >正确
                    <br/><br/>
                </div>
                <% order ++; %>
                </c:forEach>
                <button id="addJudge" class="btn btn-primary btn-xs">添加</button>
            </div>
            <% order = 1; %>
            <div id="shortQuestion">
                <h4>三、简答题</h4>
                <input type="hidden" id="maxShortID" value="${testQuestionsType2.size()}">
                <c:forEach items="${testQuestionsType2}" var="um">
                <div id="short<%=order %>">
                    <label id="shortID<%=order %>"><%=order %></label>.
                    <textarea id="shortContent<%=order %>" cols="100" rows="3"  style="vertical-align: top;">${um.content}</textarea>
                    <br/><br/>
                    <label>参考答案：</label>
                    <textarea id="shortAnswer<%=order %>" cols="100" rows="3"  style="vertical-align: top;">${um.ansLong}</textarea>
                    <br/><br/>
                    <label>分值：</label><input id="shortValue<%=order %>" type="number" value="${um.value}">
                    <br/><br/>
                </div>
                </c:forEach>
                <button id="addShort" class="btn btn-primary btn-xs">添加</button>
            </div>
        </div>
    </div>
    <br/><br/>
    <div align="center">
        <button id="submit" class="btn btn-primary btn-xs">提交</button>
    </div>
</body>
</html>