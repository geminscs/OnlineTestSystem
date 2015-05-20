/**
 * Created by Administrator on 2015/3/21.
 */
$(document).ready(function(){
	$("th").removeClass().addClass("text-center");
	$("td").removeClass().addClass("text-center");
   
    $(document).off("click",'button[name="delStu"]');
    $(document).on("click",'button[name="delStu"]',function(){
        var delStudent=$(this).parent().parent();
        var id=delStudent.find('td[name="stuID"]').text();
             
        $.ajax({
            cache: true,
            type: "POST",
            url:"DeleteStudent",
            data:{ID:id},// 你的formid
            async: true,
            complete: function(XHR, TS) {
            	if(XHR.status == 200){
            		 delStudent.remove();
            	}
            	else{
            		alert("Fail to delete");
            	}
            }
        });
    });
});