<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">

.questionJson{
	display:none;
}
</style>

<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script>
var selectedRow = -1;
$(document).ready(function(){
		
});

function responseMouseEvent(obj,type){
	if(type==1){
		obj.style.backgroundColor = "#6699CC";
	}
	else if(type==2){
		obj.style.backgroundColor = "#FFFFFF";
	}
}

function responseClickEvent(obj){
	if(obj.children[0].children[0].checked==true){
		obj.children[0].children[0].checked = false;
		selectedRow = -1;
		obj.style.backgroundColor = "#FFFFFF";
		obj.onmouseover = function(){responseMouseEvent(obj,1);};
		obj.onmouseout = function(){responseMouseEvent(obj,2);};
	}
	else{
		obj.children[0].children[0].checked = true;
		obj.style.backgroundColor = "#DFD027";//
		obj.onmouseover = null;
		obj.onmouseout = null;
		if(selectedRow != -1){
			var selectedObj = $(obj).parent().children().eq(selectedRow)[0];
			selectedObj.children[0].children[0].checked = false;
			selectedObj.style.backgroundColor = "#FFFFFF";
			selectedObj.onmouseover = function(){responseMouseEvent(selectedObj,1);};
			selectedObj.onmouseout = function(){responseMouseEvent(selectedObj,2);};
		}
		selectedRow = $(obj).index();
		$('#selectedQuestion').val(selectedRow);
	}
}
</script>
</head>
	<body>
		<div id='dia'>
			<input type = "hidden" id="selectedQuestion" value="-1">
			<table id = 'questionTable'>
				<c:forEach items="${list }" var="um">
				<tr onclick="responseClickEvent(this);" onmouseover="responseMouseEvent(this,1);" onmouseout="responseMouseEvent(this,2)" style="cursor:hand;background-color:#FFFFFF">
					<td><input type="checkbox" name="update_checkbox" id="update_checkbox" />
					</td>
					<td>${um.getContent() }</td>
					<td class="questionJson">${um.getJsonString() }</td>
				</tr>
				</c:forEach>
			</table>
			<br/><br/>
		</div>
	</body>
</html>

