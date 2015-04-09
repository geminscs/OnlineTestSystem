$(document).ready(function(){
  $("#notice").click(function(){
    $("#content").load("notice.html");
    $('li[name="stuMenu"]').removeClass();
    $(this).addClass("active");
  });
  
  $("#simTest").click(function(){
	    $("#content").load("/SimTest");
	    $('li[name="stuMenu"]').removeClass();
        $(this).addClass("active");
  });
  
  $("#test").click(function(){
	  $("#content").load("/FormalTest");
	  $('li[name="stuMenu"]').removeClass();
      $(this).addClass("active");
  });
  
  $("#grade").click(function(){
	  $("#content").load("/GetGrade");
	  $('li[name="stuMenu"]').removeClass();
      $(this).addClass("active");
  });
  
  $("#mainSetting").click(function(){
	  $("#content").load("/MainSetting");
	  $('li[name="stuMenu"]').removeClass();
  });
    
  $(document).on("click",'button[name="startTest"]',function(){
  	$("#content").load("/StartTest", {ID:this.id});
  });[]
});