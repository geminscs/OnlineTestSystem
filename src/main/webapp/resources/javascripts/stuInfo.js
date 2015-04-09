/**
 * Created by Administrator on 2015/3/21.
 */
$(document).ready(function(){
	$("th").removeClass().addClass("text-center");
	$("td").removeClass().addClass("text-center");
    $("#addStudent").off("click");
    $("#addStudent").click(function(){
        var stuName=$("#stuName").val();
        if(stuName==""){
           alert("请输入学生姓名");
            return;
        }
        var stuPassword=$("#stuPassword").val();
        if(stuPassword==""){
            alert("请输入学生密码");
        }
        $.ajax({url:"/AddStudent",type:"post",data:{name:stuName,password:stuPassword},async:true, complete:function(XHR, TS){        	
        	if(XHR.status == 200){
        		var row='<tr>'+
                '<td name="stuID" class="text-center">'+XHR.responseText+'</td>'+
                '<td class="text-center">'+stuName+'</td>'+
                '<td class="text-center">'+stuPassword+'</td>'+
                '<td class="text-center"><button  name="delStu" class="btn btn-primary btn-xs">删除</button></td>'+
                '</tr>';
            	$("#newStudent").before(row);
            	$("#stuName").val("");
            	$("#stuPassword").val("");
        	}
        	else{
        		alert(XHR.responseText);
        	}
        }});
    });

    $(document).off("click",'button[name="delStu"]');
    $(document).on("click",'button[name="delStu"]',function(){
        var delStudent=$(this).parent().parent();
        var id=delStudent.find('td[name="stuID"]').text();
        delStudent.remove();
        $.post("/DeleteStudent", {ID:id});
    });
});