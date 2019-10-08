<!--header-->
<style type="text/css">
  #collapse-target ul li a
  {
    font-weight: bold;
    font-family: verdana;
    font-style: italic;
    color: white;

  }
 #collapse-target ul li a:hover
  {
    border-bottom: 2px solid red;
  }
  #collapse-target ul li a:active
  {
    background-color: white;
  }
  #collapse-target ul li
  {
  opacity: .9;
  color: black;
  }
  #collapse-target ul 
  {
    
  }
</style>
<div class="container-fluid row">
  <div class="col-sm-7">
    <img src="bg.jpg">
  </div>
  <div class="col-sm-3" style="margin-bottom: 10px">
    <form class="form-inline" style="margin-top: 20%">
      <input class="form-control mr-sm-2" type="search" placeholder="Search" id="vSearchBox" onkeyup="javascript:searchThreads()">
    </form>
  </div>
</div>
<!--navbar-->
<nav class="navbar navbar-expand-sm  navbar-dark sticky-top" style="background-color: #4d1d7c;font-family: Montserrat, sans-serif;min-height: 80px;z-index: 9999;border-bottom: 1px solid black;font-size: 18px !important;letter-spacing: 2px;color: white">
  <img src="skill-icon.png">

  <button class="navbar-toggler" data-toggle="collapse" data-target="#collapse-target" >
    <!--this button is to make the below division whose id is collpase-target .as responsive ..span is a icon shown when screeen collapse -->
    <span class="navbar-toggler-icon">
    </span>
  </button>
  <div class="collapse navbar-collapse" id="collapse-target" style="margin-left: 30px">
    
      <%
    if(session.getAttribute("email")==null)
      {
    %>
    <ul class="navbar-nav col-sm-8">
    <li class="nav-item">
        <a class="nav-link active" href="/skillshare/homePage.jsp" style="" >Home
        </a>
      </li>
    </ul>
    <ul class="navbar-nav  col-sm-2 " style="">
      <li class="nav-link">
        <button style="background-color: #e80d65;color: white;cursor: pointer;" data-toggle="modal" data-target="#signInModal" >Login
        </button>
      </li>
      <li  class="nav-link">
        <button style="background-color: #e80d65;color: white;cursor: pointer;" data-toggle="modal" data-target="#signUpModal">SignUp
        </button>
      </li>
    </ul>
    <%}else{%>
     <ul class="navbar-nav col-sm-8">
      <li class="nav-item">
        <a class="nav-link active" href="/skillshare/homePage.jsp" style="" >Home
        </a>
      </li>
      <!--
      <li class="nav-item">
        <a class="nav-link" href="#">My_Posts
        </a>
      </li>
      <li class="navbar-nav pull-right">
        <a class="nav-link" href="#">My_Questions
        </a>
      </li>
      <li class="navbar-nav pull-right">
        <a class="nav-link" href="#">My_Answers
        </a>
      </li>
      -->
      <li class="navbar-nav pull-right">
        <a class="nav-link" href="#"    data-toggle="modal" data-target="#myModal">Add_Article
        </a>
      </li>
      <li class="navbar-nav pull-right">
        <a class="nav-link" href="#"    data-toggle="modal" data-target="#askQuestionModal">Ask_Question
        </a>
      </li>
    </ul>


    <ul class="navbar-nav  col-sm-4" >
      <img src="user-icon.png" style="width: 50px;height: 50px;margin-left: 50px" class="rounded-circle">
      <li class="nav-link">
        <button style="background-color: #e80d65;color: white;cursor: pointer;" ><%=session.getAttribute("userName")%>
        </button>
      </li>
      <li  class="nav-link">
        <form action="logout" method="post">
        <button name="" style="background-color: #e80d65;color: white;cursor: pointer;">logout
        </button>
        </form>
      </li>
    </ul>

<%}%>

  </div>
</nav>
<div id="aaabbb" style="display: none;background-color: black;z-index: 100001 !important;position: absolute;min-height: 500px" class="container col-sm-12">
<div id="searchDivision" class="container-fluid col-sm-7" style="background-color: #ed9393">
  
</div>
</div>
<!--navbar-->
<!--header-->






<script>
  //searching feature implementation
  function searchThreads()
{
//alert("load hua");
vSearchString=document.getElementById("vSearchBox").value.toLowerCase();
if(vSearchString=='')
{
document.getElementById("aaabbb").style.display="none";
return;
}
document.getElementById("aaabbb").style.display="block";
//alert(vSearchString);
var searchThreadJSON={
"searchString":vSearchString
};

var httpRequest=new XMLHttpRequest();
httpRequest.onreadystatechange=function(){
if(this.readyState==4 && this.status==200)
{
var data=httpRequest.responseText;
var applicationResponse=JSON.parse(data);
//var threads=[];
var jsonThreads=applicationResponse.result;
var l=jsonThreads.length;



var section=document.getElementById("searchDivision");
while(section.hasChildNodes())
{
  section.removeChild(section.firstChild);
}
if(l=='0')
{
  var noResult=document.createElement("label");
  noResult.innerHTML="No result Found !";
  section.appendChild(noResult);
  //alert("ghusa");
  return;
}
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
    createQ(content,code,userId);
  }
  else
  {
createT(imagePath,heading,content,time,code,userId);
  }
}

}
}
;
httpRequest.open("POST","searchThreads",true);
httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
httpRequest.send(JSON.stringify(searchThreadJSON));
}
</script>

<script type="text/javascript">
            //function to add questions in frequently asked question
            function createQ(vQuestion,threadId,userId)//thread ka type question hua tb ye call hoga and type article hone par createArticle wala function call hoga
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
              
              var section=document.getElementById("searchDivision");
              section.appendChild(mask);
              section.appendChild(space);
            }
</script>
<script type="text/javascript">
            function createT(imgPath,vHeading,vContentPart,vTime,threadId,userId)
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
                content.innerHTML=vContentPart.substring(0, 40);
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
              
              var section=document.getElementById("searchDivision");
              section.appendChild(mask);
              section.appendChild(space);
            }
</script>
