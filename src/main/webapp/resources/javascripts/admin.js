/**
 * Created by Administrator on 2015/3/20.
 */
$(document).ready(function(){
	
    $("#edit").click(function(){
    	
        $("#content").load("/EditTests");
        $('li[name="adminMenu"]').removeClass();
        $(this).addClass("active");
        
    }); 
    
    $("#mark").click(function(){
    	
        $("#content").load("/MarkTests");
        $('li[name="adminMenu"]').removeClass();
        $(this).addClass("active");
    }); 
    
    $("#stuAdmin").click(function(){
    	$('li[name="adminMenu"]').removeClass();
        $(this).addClass("active");
        $("#content").load("/StuAdmin");
    }); 
    
    $("#stuScore").click(function(){
    	$('li[name="adminMenu"]').removeClass();
        $(this).addClass("active");
        $("#content").load("/StuScore");
    }); 
    
    $("#setting").click(function(){
    	$('li[name="adminMenu"]').removeClass();
        $(this).addClass("active");
  	  $("#content").load("/Setting");
    });
    
    $("#adminSetting").click(function(){
    	$('li[name="adminMenu"]').removeClass();
    	$("#content").load("/AdminSetting");
    });
    
    $(document).on("click",'button[name="edit"]',function(){
    	$("#content").load("/EditPaper", {ID:this.id});
    });
    
    $(document).off("click",'button[name="delPaper"]');
    $(document).on("click",'button[name="delPaper"]',function(){
        var delPaper=$(this).parent().parent();
        delPaper.remove();
        $.post("/DeleteTest", {ID:this.id});
    });
       
    $(document).on("click","#addTest",function(){
       var startDate=$("#startDate").val();
       var startTime=$("#startTime").val();
       var endDate=$("#endDate").val();
       var endTime=$("#endTime").val();
       var duration=$("#duration").val();
    
       var testInfo={};
       testInfo.startDate=startDate;//2013-05-09
       testInfo.startTime=startTime;//19:00
       testInfo.endDate=endDate;
       testInfo.endTime=endTime;
       testInfo.duration=duration;
       var jsonString = JSON.stringify(testInfo);
       
       var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}
		else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				var responseId = xmlhttp.responseText;
				var row="<tr><td class='text-center'>"+responseId+"</td><td class='text-center'>"+startDate+" "+startTime +
			        "</td><td class='text-center'>"+endDate+" "+endTime+
			            "</td><td class='text-center'>"+duration+"</td><td class='text-center'><button class='btn btn-primary btn-xs' name='edit' id='"+responseId+ "'>编辑</button> <button name='delPaper' id='"+responseId+"' class='btn btn-primary btn-xs'>删除</button></td></tr>";
			        $("#newTest").before(row);
				
			}
			else if(xmlhttp.status==400 && xmlhttp.readyState==4){
				alert(xmlhttp.responseText);
			}
		}
		xmlhttp.open("POST","/AddTest ",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("jsonString="+jsonString);
   });
});