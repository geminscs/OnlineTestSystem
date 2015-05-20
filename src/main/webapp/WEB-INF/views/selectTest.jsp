<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>选择试卷</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script>
    $(document).ready(function(){
    	 
    	    $("td").removeClass().addClass("text-center");
    	    $("th").removeClass().addClass("text-center");
    	  
    	 $(document).off("click", 'button[name="revise"]');
    	 $(document).on("click",'button[name="revise"]',function(){
             var str=this.id;
             var id=str.substr("reviseTest".length,str.length-1);
             $("#content").load("/SelectStudent", {ID:id});
         });
    	
    });
    </script>
</head>
<body>
    <div align="center">
        <table  cellspacing="10" class="table table-striped table-bordered text-center bootstrap-datatable datatable responsive">

            <caption>已有考试列表</caption>
            <thead>
            <tr>
                <th>考试编号 </th>
                <th>考试开始时间 </th>
                <th>考试结束时间 </th>
                <th>考试时长(min) </th>
                <th>批改</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${list }" var="um">
            <tr>
                <td>${um.getTest().getId() }</td>
                <td>${um.getFormatStartTime() } </td>
                <td>${um.getFormatEndTime() } </td>
                <td>${um.getTest().getDuration() } </td>
                <td><button name="revise" id="reviseTest${um.getTest().getId() }" class="btn btn-primary btn-xs">批改</button>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>

    </div>
</body>
</html>