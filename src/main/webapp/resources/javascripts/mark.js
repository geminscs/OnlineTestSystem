/**
 * Created by Administrator on 2015/3/23.
 */
$(document).ready(function(){
    $("#submitScore").click(function(){
        var testIDVar=$("#testID").val();
        var stuIDVar=$("#stuID").val();
        var scoreArray=[];
        var questionNum=$('div[name="question"]').length;
        for(var i=1;i<=questionNum;i++){
            var scoreOb={};
            var n=$("#score"+i).val();
            var v=$("#value"+i).val();
            if(isNaN(n)||n>v||n<0||n==''){
                alert("第"+i+"题请输入正确得分");
            }else{
                scoreOb.id=$("#questionID"+i).val();
                scoreOb.score=n;
            }
            scoreArray[i-1]=scoreOb;
        }
        var lastVar = JSON.stringify(scoreArray);
        $("#content").load("/FormalJudge", {jsonString:lastVar, testID:testIDVar, studentID:stuIDVar});
    });
});