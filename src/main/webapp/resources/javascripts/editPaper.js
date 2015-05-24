/**
 * Created by Administrator on 2015/3/21.
 */
$(document).ready(function(){
	var g_selectedQuesIndex = -1;
	var g_selectedQuesType = -1;
    $(document).off("click",'button[name="selectFromDatabase"]');
    $(document).on("click",'button[name="selectFromDatabase"]',function(){
    	g_selectedQuesIndex = $(this).parent().children().eq(0).html();
    	g_selectedQuesType = 0;
    	$('#questions').empty();
        $('#dialog').show();
    });
    
    $(document).on("click",'button[name="judgeFromDatabase"]',function(){
    	g_selectedQuesIndex = $(this).parent().children().eq(0).html();
    	g_selectedQuesType = 1;
    	$('#questions').empty();
        $('#dialog').show();
    });
    
    $(document).on("click",'button[name="shortFromDatabase"]',function(){
    	g_selectedQuesIndex = $(this).parent().children().eq(0).html();
    	g_selectedQuesType = 2;
    	$('#questions').empty();
        $('#dialog').show();
    });
    
    $('#confirm').click(function(){
    	var selectedQuestionIndex = $('#selectedQuestion').val();
    	if(!selectedQuestionIndex || selectedQuestionIndex < 0){
    		$('#dialog').hide();
    		return;
    	}
    	var selectedTr = $('#questionTable').children().children().eq(selectedQuestionIndex).children().eq(1);
    	var tdObj = $('#questionTable').children().children().eq(selectedQuestionIndex).children().eq(2);
    	var jsonStr = tdObj.html();
    	var jsonObj = JSON.parse(jsonStr);
    	if(jsonObj.type == 0){
    		 $('#selectQuestion').children('div').eq(g_selectedQuesIndex - 1).children('textarea').val(jsonObj.content);
    		 $('#selectQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input').eq(1).val(jsonObj.ansA);
    		 $('#selectQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input').eq(3).val(jsonObj.ansB);
    		 $('#selectQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input').eq(5).val(jsonObj.ansC);
    		 $('#selectQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input').eq(7).val(jsonObj.ansD);
    	 
    		 $('#selectQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input[type="radio"]').removeAttr('checked');
    		 $('#selectQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input[type="radio"]').eq(jsonObj.ansShort).prop("checked", true);
    	}
    	else if(jsonObj.type == 1){
    		$('#judgeQuestion').children('div').eq(g_selectedQuesIndex - 1).children('textarea').val(jsonObj.content);
    		$('#judgeQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input[type="radio"]').removeAttr('checked');	
    		$('#judgeQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input[type="radio"]').eq(jsonObj.ansShort).prop("checked",true);
    	}
    	else if(jsonObj.type == 2){
    		$('#shortQuestion').children('div').eq(g_selectedQuesIndex - 1).children('textarea').eq(0).val(jsonObj.content);
    		$('#shortQuestion').children('div').eq(g_selectedQuesIndex - 1).children('textarea').eq(1).val(jsonObj.ansLong);
    		$('#shortQuestion').children('div').eq(g_selectedQuesIndex - 1).children('input').val(jsonObj.value);
    	}
    	$('#dialog').hide();
    });
    
    $('#cancel').click(function(){
    	$('#dialog').hide();
    });
    
    $('#point').change(function(){
    	var seletedPoint = $(this).children('option:selected').val();
    	$('#questions').load( '/GetQuestion', {point:seletedPoint, type:g_selectedQuesType});
    });
	
    $("#addSelect").click(function(){
        var id=$("#maxSelectID").val();
        id++;
        var str='<div id="select'+id+'"><label id="selectID'+id+'">'+id+'</label>. '+
        '<textarea id="selectContent'+id+'" cols="100" rows="3"  style="vertical-align: top;"></textarea>'+
        '<br/><br/>'+
        '<input type="radio" name="selectAnswer'+id+'" value="0">A.<input type="text" id="select'+id+'option0">'+
        '<br/>'+
        '<input type="radio" name="selectAnswer'+id+'" value="1">B.<input type="text" id="select'+id+'option1">'+
        '<br/>'+
        '<input type="radio" name="selectAnswer'+id+'" value="2">C.<input type="text" id="select'+id+'option2">'+
        '<br/>'+
        '<input type="radio" name="selectAnswer'+id+'" value="3">D.<input type="text" id="select'+id+'option3">'+
        '<br/><br/>'+
        '<button name="selectFromDatabase" class="btn btn-primary btn-xs">从题库中添加</button>'+
        '<br/><br/>'+
        '</div>';
        $(this).before(str);
        $("#maxSelectID").val(id);
    });

    $("#addJudge").click(function(){
        var id=$("#maxJudgeID").val();
        id++;
        var str='<div id="judge'+id+'">'+
            '<label id="judgeID'+id+'">'+id+'</label>. '+
            '<textarea id="judgeContent'+id+'" cols="100" rows="1"  style="vertical-align: top;"></textarea>'+
            '<br/><br/>'+
            '<input type="radio" name="judgeAnswer'+id+'" value="0">错误'+
            '<input type="radio" name="judgeAnswer'+id+'" value="1">正确'+
            '<br/><br/>'+
            '<button name="judgeFromDatabase" class="btn btn-primary btn-xs">从题库中添加</button>'+
            '<br/><br/>'+
            '</div>';
        $(this).before(str);
        $("#maxJudgeID").val(id);
    });

    $("#addShort").click(function(){
        var id=$("#maxShortID").val();
        id++;
        var str='<div id="short'+id+'">'+
        '<label id="shortID'+id+'">'+id+'</label>. '+
        '<textarea id="shortContent'+id+'" cols="100" rows="3"  style="vertical-align: top;"></textarea>'+
        '<br/><br/>'+
        '<label>参考答案：</label>'+
        '<textarea id="shortAnswer'+id+'" cols="100" rows="3"  style="vertical-align: top;"></textarea>'+
        '<br/><br/>'+
        '<label>分值：</label><input id="shortValue'+id+'" type="number">'+
        '<br/><br/>'+
        '<button name="shortFromDatabase" class="btn btn-primary btn-xs">从题库中添加</button>'+
        '<br/><br/>'+
        '</div>';
        $(this).before(str);
        $("#maxShortID").val(id);
    });

    $("#submit").click(function(){
        var questionArray=[];
        var maxSelect=parseInt($("#maxSelectID").val());
        var maxJudge=parseInt($("#maxJudgeID").val());
        var maxShort=parseInt($("#maxShortID").val());
        for(var i=1;i<=maxSelect;i++){
            var n = $('[name="selectAnswer'+i+'"]:checked');
            var question={};
            question.id=parseInt($("#selectID"+i).text());
            question.type=0;
            alert(n.val());
            if(n.length<1){
                alert ("选择题第"+i+"题请至少选择一项！");
                return;

            }
            else{

                question.answer=n.val();
                question.content=$("#selectContent"+i).val();
               // alert(question.content);
                question.option0=$("#select"+i+"option0").val();
                question.option1=$("#select"+i+"option1").val();
                question.option2=$("#select"+i+"option2").val();
                question.option3=$("#select"+i+"option3").val();
            }
            questionArray[i-1]=question;
        }

       /* for(var i=0;i<maxSelect;i++){
            alert(questionArray[i].id+" type:"+questionArray[i].type+questionArray[i].content+questionArray[i].option0+
            questionArray[i].option1+questionArray[i].option2+questionArray[i].option3+questionArray[i].answer)
        }*/

        for(var i=1;i<=maxJudge;i++){
            var n = $('[name="judgeAnswer'+i+'"]:checked');
            var question={};
            question.id=parseInt($("#judgeID"+i).text());
            question.type=1;
            //alert(question.id.toString());
            if(n.length<1){
                alert ("判断题第"+i+"题请至少选择一项！");
                return;
            }
            else{
                question.answer=n.val();
                question.content=$("#judgeContent"+i).val();
                //alert(question.content);
            }
            questionArray[maxSelect+i-1]=question;
        }

       /* for(var i=0;i<maxSelect+maxJudge;i++){
            alert(questionArray[i].id.toString()+" type:"+questionArray[i].type+questionArray[i].content+questionArray[i].answer)
        }*/

        for(var i=1;i<=maxShort;i++){
            var question={};
            question.type=2;
            question.id=parseInt($("#shortID"+i).text());
            question.content=$("#shortContent"+i).val();
            question.answer=$("#shortAnswer"+i).val();
            var v = $("#shortValue"+i).val();
            if(isNaN(v)||v<0||v==''){
                alert("第"+i+"题请输入正确得分");
                return;
            }
            question.value=$("#shortValue"+i).val();
            questionArray[maxSelect+maxJudge+i-1]=question;
        }

        /*for(var i=0;i<maxSelect+maxJudge+maxShort;i++){
            alert(questionArray[i].id.toString()+" type:"+questionArray[i].type+questionArray[i].content+questionArray[i].answer)
        }*/

        testInfo={};
        testInfo.id=$("#testID").val();
        testInfo.startDate=$("#startDate").val();
        testInfo.startTime=$("#startTime").val();
        testInfo.endDate=$("#endDate").val();
        testInfo.endTime=$("#endTime").val();
        testInfo.duration=$("#duration").val();

        var finalStr = JSON.stringify(questionArray);
        var testStr = JSON.stringify(testInfo);
        //$("#content").load("/SubmitPaper", {jsonString:finalStr, testInfoString:testStr});
    });
});