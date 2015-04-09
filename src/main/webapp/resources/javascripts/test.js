
$(document).ready(function(){
	var selectNum=$(".selectQuestion").length;
	var judgeNum=$(".judgeQuestion").length;;
	var shortNum=$(".shortQuestion").length;;
  $("#submit").click(function(){
	  
	  var answerArray=[];
	  for(var j = 1; j < selectNum+1; j ++ ){
			var n = $('[name="selectAnswer'+j+'"]:checked');
			var str={};
			str.ID=$("#selectID"+j).val();
			if(n.length<1){
				//alert (""+j+"组请至少选择一项！"+str.ID);
				str.answer=-1;
				//a[j-1]=-1;
			}
			else{
				//a[j-1]=n.val();
				str.answer=n.val();
			}
			answerArray[j-1]=str;
	  }
	  
	  for(var j = 1; j < judgeNum+1; j ++ ){
			var n = $('[name="judgeAnswer'+j+'"]:checked');
			var str={};
			str.ID=$("#judgeID"+j).val();
			if(n.length<1){
				//alert (""+j+"组请至少选择一项！");
				str.answer=-1;
				//a[j-1]=-1;
			}
			else{
				//a[j-1]=n.val();
				str.answer=n.val();
			}
			answerArray[selectNum+j-1]=str;
	  }
	  
	  for(var j = 1; j < shortNum+1; j ++ ){
			var n = $('[name="shortAnswer'+j+'"]');
			var str={};
			str.ID=$("#shortID"+j).val();
			
			//a[j-1]=n.val();
			str.answer=n.val();
			answerArray[selectNum+judgeNum+j-1]=str;
	  }
	  var last = JSON.stringify(answerArray);
	  
	 
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
		}
		xmlhttp.open("POST","/SimJudge",true);
		xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xmlhttp.send("jsonString="+last);*/
	  $("#content").load("/SimJudge", {jsonString:last});

  });
});

function loadXMLDoc(){
	
	
	
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
		 document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
		}
	}
	var str2 = {};
	str2.name = "tangbichi";
	str2.age = "23";

	var str1 = [];
	str1[0] = str2;
	str1[1] = str2;
	var last=JSON.stringify(str1);

	xmlhttp.open("POST","/simJudge",true);
	xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	xmlhttp.send("jsonString="+last);
}