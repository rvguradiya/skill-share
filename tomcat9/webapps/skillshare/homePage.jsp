<!DOCTYPE html>
<html>
  <head>
    <title>
    </title>
	<jsp:include page="library.jsp" />
<script>
  function setupView()
{
//alert("load hua");
var httpRequest=new XMLHttpRequest();
httpRequest.onreadystatechange=function(){
if(this.readyState==4 && this.status==200)
{
var data=httpRequest.responseText;
var applicationResponse=JSON.parse(data);
//var threads=[];
var jsonThreads=applicationResponse.result;
var l=jsonThreads.length;
for(var i=0;i<l;i++)
{
  //do a work to create post and create question 
  code=jsonThreads[i].code;
  subject=jsonThreads[i].subject;
  heading=jsonThreads[i].heading;
  content=jsonThreads[i].content;
  link=jsonThreads[i].link;
  imagePath=jsonThreads[i].imagePath;
  type=jsonThreads[i].type;
  userId=jsonThreads[i].userId;
  time=jsonThreads[i].time;
  //alert(code+" "+subject+" "+heading+" "+content+" "+link+" "+imagePath+" "+type+" "+userId+" "+time);
  if(type=='question')
  {
    createQuestion(content,code,userId);
  }
  else
  {
createThread(imagePath,heading,content,time,code,userId);
  }
}

}
}
;
httpRequest.open("GET","getThreads",true);
httpRequest.send();
}
</script>
<script type="text/javascript">
            //function to add questions in frequently asked question
            function createQuestion(vQuestion,threadId,userId)//thread ka type question hua tb ye call hoga and type article hone par createArticle wala function call hoga
            {
              var mask=document.createElement("div");
              mask.classList.add("container");
              mask.style="min-height: 50px;background-color:white; font-weight: bold;margin-right: 2px;border: 1px solid green;border-radius: 30px;";
              var vquestion=document.createElement("a");
              vquestion.style="word-wrap: break-word;cursor: pointer;"
              vquestion.innerHTML=vQuestion;
              vquestion.setAttribute("href","/skillshare/postDetails.jsp?threadId="+threadId+"&userId="+userId);  //we send threaId to postDetails.jsp to fecth detailed record.
              var space=document.createElement("div");
              space.style="min-height: 15px";
              mask.appendChild(vquestion);
              
              var section=document.getElementById("frequentlyAskedQuestions");
              section.appendChild(mask);
              section.appendChild(space);
            }
</script>
<script type="text/javascript">
            function createThread(imgPath,vHeading,vContentPart,vTime,threadId,userId)
            {
            var mask=document.createElement("div");
              mask.classList.add("row");
              mask.style="border: 1px solid green;border-radius: 25px;background-color: white;opacity: .9";
            var imageSection=document.createElement("div");
              imageSection.classList.add("col-sm-4");
              imageSection.style="left:0";
            var img=document.createElement("img");
                img.setAttribute("src",imgPath);
                img.classList.add("rounded");
                img.classList.add("img-fluid");
                img.style=";height: 10rem";
            var center=document.createElement("CENTER");
                center.appendChild(img);
                imageSection.appendChild(center);
            var contentSection=document.createElement("div");
              contentSection.classList.add("col-sm-8");
              contentSection.style="min-height: 50px;padding:3px";
            var heading=document.createElement("p");
                heading.style="width: 100%;word-wrap: break-word;font-weight: bold;font-size: 21px";
                heading.innerHTML=vHeading;
            var content=document.createElement("p");
                content.style="width: 100%;word-wrap: break-word;margin-top: 3px;font-style: italic;font-size: 18px";
                content.innerHTML=vContentPart.substring(0, 100);
            var link=document.createElement("a");
                link.style="cursor: pointer;"
                link.innerHTML="read more.......";
                link.setAttribute("href","/skillshare/postDetails.jsp?threadId="+threadId+"&userId="+userId); 
            var time=document.createElement("label");
                time.innerHTML=vTime;
                time.style="margin-left:50%";
            contentSection.appendChild(heading);
            contentSection.appendChild(content);
            contentSection.appendChild(link);
            contentSection.appendChild(time);
            mask.appendChild(imageSection);
            mask.appendChild(contentSection);

            var space=document.createElement("div");
              space.style="min-height: 5px";
              //mask.appendChild(question);
              
              var section=document.getElementById("recentArticle");
              section.appendChild(mask);
              section.appendChild(space);
            }
</script>

</head>
  <body>
    <!--include header-->
    <jsp:include page="myHeader.jsp" />
    <!--body section-->
    <div class="container-fluid" id="homePage" style="display: block;padding-bottom: 100px">
      <div class="row" style="margin-top: 10px;" id="body">
      	

      	<div class="col-sm-3">
      		<h5 style="background-color: #050621;color: white;padding: 12px">Frequently Asked Question</h5>
        <marquee id="frequentlyAskedQuestions" direction="up"  style="background-color: #8f1edb;height: 600px" onmouseover="this.stop()" onmouseout="this.start()">
          <!--here we append frequently asked questions-->
        </marquee>
        </div>
        
        <div class="col-sm-7" >
        <h5 style="background-color: #050621;color: white;padding: 12px;">Recent Posts</h5>
        <div class="col-sm-12" id="recentArticle" style="background-color:#ed9393;height: auto;padding-top: 1px">

          <!--here we recent Articles-->
        </div>
        </div>

      	<div class="col-sm-2">
      		<h5 style="background-color: #050621;color: white;padding: 12px">Topics</h5>
        
      	<div id="frequentlyAskedQuestions" style="background-color: #8f1edb;height: auto;padding-top: 5px">
           
           	<div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;" href="" onclick="javascript:searchThreads("Database")" >Database
              </a>
          	</div>
          	<div id="space" style="min-height: 5px"></div>
        	

            <div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;" href="">Python
              </a>
            </div>
            <div id="space" style="min-height: 5px"></div>


            <div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;" href="">SQL
              </a>
            </div>
            <div id="space" style="min-height: 5px"></div>



            <div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;" href="">Distributed System
              </a>
            </div>
            <div id="space" style="min-height: 5px"></div>


            <div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;" href="">Date Structure
              </a>
            </div>
            <div id="space" style="min-height: 5px"></div>

            <div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;" href="">Principal of Programmming languages
              </a>
            </div>
            <div id="space" style="min-height: 5px"></div>


            <div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;" href="">BootStrap
              </a>
            </div>
            <div id="space" style="min-height: 5px"></div>
            <div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;" href="">JavaScript
              </a>
            </div>
            <div id="space" style="min-height: 5px"></div>

<div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;">java 
              </a>
          	</div>
          	<div id="space" style="min-height: 5px"></div><div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;">c++
              </a>
          	</div>
          	<div id="space" style="min-height: 5px"></div><div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;">operating system
              </a>
          	</div>
          	<div id="space" style="min-height: 5px"></div>


        </div>
        </div>



      </div>
    </div>
    <!--body section-->
<script>
window.addEventListener('load',setupView);
</script>
<!--Inclide askQuestionForm Modal-->
<jsp:include page="askQuestionForm.jsp"/>
<!--Inclide addPostForm Modal-->
<jsp:include page="addPostForm.jsp"/>
<!--Inclide signUpForm Modal-->
<jsp:include page="signUpForm.jsp"/>
<!--Inclide signInForm Modal-->
<jsp:include page="signInForm.jsp"/>













    <!-- Footer section add later -->
    <!-- Footer -->
  </body>
</html>
