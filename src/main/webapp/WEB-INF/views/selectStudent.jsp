<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>选择学生</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script>
    $(document).ready(function(){ 
    	$("td").removeClass().addClass("text-center");
    	$("th").removeClass().addClass("text-center");	   
    	$(document).off("click", 'button[name="markStudent"]');   	
    	$(document).on("click",'button[name="markStudent"]',function(){
             var str=this.id;
             var id=str.substr("reviseStu".length,str.length-1);
             var testIDVar=$("#testID").val();
             $("#content").load("/MarkStudent", {ID:id, testID:testIDVar});
         });
		
    	 
         $("#returnSelectTest").click(function(){
        	 $("#content").load("/MarkTests");
         });
    });
    
    </script>
</head>
<body>
    <div align="center">
        <input type="hidden" id="testID" value="${testId }">
        <table  cellspacing="10" class="table table-striped table-bordered text-center bootstrap-datatable datatable responsive">
            <caption>学生列表</caption>
            <thead>
            <tr>
                <th>学生</th>
                <th>批改</th>
            </tr>
            </thead>
            <tbody>
           <c:forEach items="${list }" var="um">
            <tr>
                <td>${um.getAccount() }</td>
                <td><button name="markStudent" id="reviseStu${um.getAccount() }" class="btn btn-primary btn-xs">批改</button>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <br/>
        <button id="returnSelectTest" class="btn btn-primary btn-xs">返回</button>
    </div>
</body>
</html>