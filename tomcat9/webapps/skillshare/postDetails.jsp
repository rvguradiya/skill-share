<!DOCTYPE html>
<html>
  <head>
    <title>
    </title>
	<jsp:include page="library.jsp" />



<%
HttpSession s=request.getSession();
//System.out.println(Integer.parseInt((request.getParameter("threadId"))+3));
//we get the thread details from database and check their type to display further information.
//we also get user details from database and display them on postDetails.jsp
//System.out.println(request.getParameter("abc"));
%>
<label id="questionId" style="display: none;"><%=request.getParameter("threadId")%></label>
<label id="userId" style="display: none;"><%=request.getParameter("userId")%></label>
<label id="questionId" style="display:none;"><%=request.getParameter("threadId")%></label>

<label id="logInInfo" style="display:;"><%=s.getAttribute("userId")%></label>

<script type="text/javascript">
//service function to get post Details and comments of that post start 

function loadThreadDetails()
{
//alert("load hua");
pid=document.getElementById("questionId").innerHTML;
uid=document.getElementById("userId").innerHTML;
var threadJSON={
"threadId":pid
};
var httpRequest=new XMLHttpRequest();
httpRequest.onreadystatechange=function(){
if(this.readyState==4 && this.status==200)
{
var data=httpRequest.responseText;
var applicationResponse=JSON.parse(data);
//var threads=[];
var jsonThread=applicationResponse.thread;
var jsonThreadComments=applicationResponse.comments;

var threadHeading=jsonThread.threadHeading;
var threadCreatedDate=jsonThread.threadCreatedDate;
var threadImage=jsonThread.threadImage;
var threadContent=jsonThread.threadContent;
var userName=jsonThread.userName;
var userProfile=jsonThread.userProfile;
var email=jsonThread.email;
var city=jsonThread.city;
var age=jsonThread.age;
var designation=jsonThread.designation;


//alert(jsonThread);
//alert(jsonThreadComments);
var l=jsonThreadComments.length;
createPost(pid,uid,threadHeading,threadContent,threadCreatedDate,threadImage,userName,userProfile,l);



for(var i=0;i<l;i++)
{
   //work to append comments
  var threadCommentId=jsonThreadComments[i].threadCommentId;
  var threadCommentContent=jsonThreadComments[i].threadCommentContent;
  var threadCommentCreatedDate=jsonThreadComments[i].threadCommentCreatedDate;
  var commentUserName=jsonThreadComments[i].userName;
  var commentUserProfile=jsonThreadComments[i].userProfile;
  var commentUserCity=jsonThreadComments[i].city;
  var commentUserAge=jsonThreadComments[i].age;
  var commentUserDesignation=jsonThreadComments[i].designation;
  createCommentBox(pid,threadCommentContent,threadCommentCreatedDate,commentUserProfile,commentUserName,threadCommentId);
  
 //alert(code+" "+subject+" "+heading+" "+content+" "+link+" "+imagePath+" "+type+" "+userId+" "+time);
}



}
}
;
httpRequest.open("POST","getThreadDetails",true);
httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
httpRequest.send(JSON.stringify(threadJSON));
//why this is not a request of type GET
}
//service function to get post Details and comments of that post ends
</script>











<!--this how to use java variables value inside javascript function-->
    <script type="text/javascript">
    function makeid( length ) 
      {
        var str = "";
        for ( ; str.length < length; str += Math.random().toString( 36 ).substr( 2 ) );
        return str.substr( 0, length );

      }
    </script>
    <script type="text/javascript">
      function initialize()
      { 
      x=document.getElementById("questionId");
      y=document.getElementById("userId");
      alert(x.innerHTML+"  "+y.innerHTML);
        q="What are constructors in Java?";
        a="In Java, constructor refers to a block of code which is used to initialize an object. It must have the same name as that of the class. Also, it has no return type and it is automatically called when an object is created.There are two types of constructors:Default constructor Parameterized constructor";
        createPost(x.innerHTML,y.innerHTML,"","","","","","");
     
      }
      window.addEventListener('load',loadThreadDetails);
    </script>
  </head>
  <body>
    <!--include header-->
    <jsp:include page="myHeader.jsp"/>
    

    <!--post Description-->
    <div id="postSection" class="container-fluid" style="padding-bottom: 30px;display: none;left: 0px; top: 0px; position: relative; background-color:white;opacity: .9;margin-top: 20px">
    </div>
    <!--post Description-->

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

