/**
 * Created by Administrator on 2015/3/20.
 */
$(document).ready(function(){

    $(document).on("click",'button[name="edit"]',function(){
    	/*var xmlhttp;
		if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
			xmlhttp=new XMLHttpRequest();
		}
		else{// code for IE6, IE5
			xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.onreadystatechange=function(){
			if (xmlhttp.readyState==4 && xmlhttp.status==200)
			{
				document.getElementById("content").innerHTML=xmlhttp.responseText;
			}
			else if(xmlhttp.status==400 && xmlhttp.readyState==4){
				alert(xmlhttp.responseText);
			}
		}
		xmlhttp.open("POST","/EditPaper ",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("ID="+this.id);*/
    	$("#content").load("/EditPaper", {ID:this.id});
    });

 
    $("#addTest").click(function(){
    	 var startDate;
    	 var startTime;
    	 var endDate,endTime;
    	 var duration;
 
        startDate=$("#startDate").val();
        startTime=$("#startTime").val();
        endDate=$("#endDate").val();
        endTime=$("#endTime").val();
        duration=$("#duration").val();
     
        var testInfo={};
        testInfo.startDate=startDate;//2013-05-09
        testInfo.startTime=startTime;//19:00
        testInfo.endDate=endDate;
        testInfo.endTime=endTime;
        testInfo.duration=duration;
        var jsonStringVar = JSON.stringify(testInfo);
        
        $.ajax({url:"/AddTest",type:"post",data:{jsonString:jsonStringVar},async:true, complete:function(XHR, TS){        	
        	if(XHR.status == 200){
        		var row='<tr>'+
                '<td>'+XHR.responseText+'</td>'+
                '<td>'+startDate+'</td>'+
                '<td>'+endDate+'</td>'+
                '<td>'+duration+'</td>'+
                '<td><button  name="delStu" class="btn btn-primary btn-xs">删除</button></td>'+
                '</tr>';
            	$("#newTest").before(row);
 
        	}
        	else{
        		alert(XHR.responseText);
        	}
        }});
        
    });

});