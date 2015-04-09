/**
 * Created by Administrator on 2015/3/25.
 */
$(document).ready(function(){
	 
	    $("td").removeClass().addClass("text-center");
	    $("th").removeClass().addClass("text-center");
	    
    $(document).off("click",'button[name="selectScoreList"]');
    $(document).on("click",'button[name="selectScoreList"]',function(){
        var tr=$(this).parent().parent();
        var id=tr.find('td[name="testID"]').text();
        $("#content").load("/ShowScoreList", {ID:id});
    });
});