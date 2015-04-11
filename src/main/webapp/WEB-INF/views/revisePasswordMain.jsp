<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>修改密码</title>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
            $("#submitNewPassword").off("click");
            $("#submitNewPassword").on("click",function(){
                var newPassword1=$("#newPassword").val();
                var newPassword2=$("#confirmPassword").val();
                if(newPassword1!=newPassword2){
                    alert("两次新密码输入的结果不一致，请重新输入");
                    return;
                }else{
                	$.ajax({
                        cache: true,
                        type: "POST",
                        url:"MainSetting",
                        data:$('#changePassword').serialize(),// 你的formid
                        async: false,
                        complete: function(XHR, TS) {
                        	if(XHR.status == 200){
                        		 alert(XHR.responseText);
                                 location.href = "/Main";
                        	}
                        	else{
                        		alert(XHR.responseText);
                        	}
                        }
                    });
                }

            });
        });
    </script>
</head>
<body>
    <div align="center">
        <form method="post" action="" id="changePassword">
            <label>修改密码</label>
            <br/><br/>
            <label>当前密码：</label><input type="password" id="oldPassword" name="oldPassword" placeholder="请输入当前的密码">
            <br/><br/>
            <label>新的密码：</label><input type="password" id="newPassword" name="newPassword" placeholder="请输入新密码">
            <br/><br/>
            <label>重复一次：</label><input type="password" id="confirmPassword" name="confirmPassword" placeholder="请再输入一次新密码">
            <br/><br/>
        </form>  
        <button id="submitNewPassword" class="btn btn-primary btn-s">提交</button>
    </div>
</body>
</html>