<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>网上调研系统</title>
    <link href="css/bootstrap.min.css" rel="stylesheet"type="text/css">
    <script src="js/jquery.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <style>
        .center{
            text-align: left;n:center;
            font-weight:bold;
            position:relative;
            left:200px;
        }
        .radiotext{
            text-indent:50px;
            position:relative;
            left:200px;
            font-style:italic;
            font-weight:bold;
        }
        .hide{
            display: none;
            position:fixed;
        }
        .clickhide{
            position: fixed;
            text-align: center;
            top: 300px;
            display: block;
            right:50%;
        }
        .from{
        position:absolute;
        background-color:#bbff99;
        height: 265px;
        width:140px;
        float:left;
        z-index:-1;
        margin=-20px'
        }
        .pinkhr{
            color:pink;border-top: 2px dashed; border-bottom: 1px dashed; height: 1px; width: 70%;
        }
    </style>
</head>
<!--part1-->
<div class="container-fluid" id="container" style="width: 1250px;background-color: #eeffee;opacity:0.9; ">
    <!--è£é¥°-->
    <div id="header" style="background-color:#FFFFFF;">
        <h1 style="margin-bottom:-10px;">
            <p align="center"><img src="image/head.jpg" width="1250" height="250"></p></h1>

    <div style="position:absolute;background-color:#bbff99;height:500px;px;width:140px;float:left;z-index:-1;"></div>
    <div style="position:absolute;background-color:#bbff99;height:500px;width:140px;float:right;left:1100px;z-index:-1;"></div>
    <hr style="border:2px dashed;color:pink;z-index:1;">
    </div>
    <!--å¼å¤´-->
<h2 style="text-align:center;color: #000000;font-weight:bold;position:relative;top:15px;">现代大学生恋爱观</h2>
    <div>
    <a href="login.html" style="position: absolute;left: 200px;"><img src="image/back.PNG" alt="error"></a>
    </div>
    <div>
    <%
    int formcount=1;%>
			
			<table style="width: 70%; margin: 44px auto"
			class="table table-striped table-bordered table-hover  table-condensed"
			align='center' border='1' cellspacing='0'>
	          
	          	
		<c:forEach items="${questions}" var="question" varStatus="st">
		
			  	<form action="ResultServlet" method="post" id="form<%=formcount%>" target='ifr'+<%=formcount%> >
					
					<hr class='pinkhr'>
					<tr>
					<input type="hidden" name="id" value="${question.question_id}">
					    <p class='radiotext'><%=formcount %>:&nbsp;${question.question_name};</p>
						<p class='radiotext'><input type='radio' name='answer' value='A' >A:&nbsp;${question.question_answerA}</p>
						<p class='radiotext'><input type='radio' name='answer' value='B' >B:&nbsp;${question.question_answerB}</p>
						<p class='radiotext'><input type='radio' name='answer' value='C' >C:&nbsp;${question.question_answerC}</p>
						<p class='radiotext'><input type='radio' name='answer' value='D' >D:&nbsp;${question.question_answerD}</p>
					</tr>
					<hr class='pinkhr'>
					<div class="text"+formcount style="text-align:center;">
							<!--  <input type="submit" value="提交" style="color:#ffffff;background-color: hotpink;">-->
					</div>
			</form>
			    <!-- iframe映射 -->
			<iframe name= 'ifr'+<%=formcount %> src="ResultServlet" class = 'hide'></iframe>
			<%formcount++; %>
			
		</c:forEach>
				    <!-- 提交按钮 -->
			<button onclick="update()" id="udbutton" type="submit" style="color:#ffffff;background-color: hotpink;" > 提交</button>		
		</table>

    </div>
    
    <!-- 提交函数 -->
 
    
    
    <br>
   
    </div>

   	<!--	<script>
        var isDisabled=0;

        function upDate(){

            if(isDisabled==1){
                alert('您已完成问卷');
                return;
            }
            //formcount=<?php //echo "$formcount"?>//;
            //for(var i=1;(i-1)<=formcount;i++) {
            //    var formele = document.getElementById("form" + i);
            //    if(formele.answer.value=='A')formcount--;
            //    if(formele.answer.value=='B')formcount--;
            //    if(formele.answer.value=='C')formcount--;
            //    if(formele.answer.value=='D')formcount--;
            //
            //
            //}
            //if(formcount>0){
            //    alert("还有"+formcount+"个问题未完成");
            //    return;
            //}
            alert('是否确定提交');
            var j=document.getElementById("demo0").textContent;
            var formele = "form0";
            var formval = null;
            var formque = null;
            j++;
            for(var i='1';i<j;i++){
                var formele = document.getElementById("form"+i);
                var formval = formele.answer.value;
                var formque = formele.question.value;
                document.getElementById("demo"+i).innerHTML = formque+":"+formval;
                formele.submit();
                // window.location="result.php"
            }



            j--;
            document.getElementById("demo0").innerHTML = j;
            document.getElementById("result").style.display='block';
            isDisabled =1;
            document.getElementById("update").innerText='已提交';
            document.getElementById("update").style.backgroundColor='#dddddd';

        }

    </script>
    <script>
        function back(){
            javaScript:history.go(-1);
            document.getElementById("result").style.display='none';
            //window.location="result.php"
        }

    </script>-->
</div>
<!--part3-->
<div id="footer" style="background-color:#7FFFD4;height:30px;text-align:center;width:100%">
        Copyright </div>

</html>