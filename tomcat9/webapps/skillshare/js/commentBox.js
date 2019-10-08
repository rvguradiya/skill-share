
//parentId,threadCommentContent,threadCommentCreatedDate,commentUserProfile,commentUserName,threadCommentId
function createCommentBox(parent,msg,vTime,vImage,vUserName,vThisDotId)
  {
    
  var pp=makeid(5);	

  //alert(parent+" -- hii  --  "+msg+" "+time)
  //var r = Math.random().toString(36).substring(5);
  var mask=document.createElement("div");
 // mask.setAttribute();
  mask.classList.add("media");
  mask.classList.add("p-3");
  var profile=document.createElement('img');
  profile.setAttribute("src",vImage);
  profile.style="width:70px;height:70px";
  profile.classList.add('rounded-circle');
  mask.appendChild(profile);
  var body=document.createElement('div');
  body.classList.add("media-body");
  var bodyId="b"+pp;
  body.setAttribute("id",vThisDotId);
  var heading=document.createElement('h6');
  heading.innerHTML=vUserName+" says : ";
  heading.style="margin-top:5px;font-style:oblique"
  var time=document.createElement('label');
  time.innerHTML="posted on : "+vTime;
  time.style="color:#8e97a5;white-space: pre-wrap;float: right;font-size: small;";
  heading.appendChild(time);
  body.appendChild(heading);
  var content=document.createElement('p');
  content.innerHTML=msg;
  content.style="font-family:Times New Roman, Times, serif;white-space: pre-wrap;";
  body.appendChild(content);


// view and hide reply functionalities starts
  var repliesCount=document.createElement('label');
  repliesCount.style="font-weight: ;color: skyblue;cursor: pointer;font-size:2;margin-right:8px";
  repliesCount.innerHTML="Replies : ";
  

 var viewReplies=document.createElement('label');
  viewReplies.style="font-weight: ;color: skyblue;cursor: pointer;font-size:4;margin-right:8px";
  viewReplies.innerHTML="ViewReplies";
   viewReplies.onclick=function()
  {
    this.nextSibling.style.display="inline";
    this.style.display="none";
    this.value=vThisDotId;
    //alert(this.value);
    //replies ko load krne se phle saare child destroy krna he
    loadReplies(this.value);
  //khud ko hide krke hide replies ko show krna

  };






  var hideReplies=document.createElement('label');
  hideReplies.style="font-weight: ;color: red;cursor: pointer;font-size:4;margin-right:8px";
  hideReplies.innerHTML="HideReplies";
  hideReplies.style.display="none";
  hideReplies.onclick=function()
  {
  this.previousSibling.style.display="inline";
  this.style.display="none";
  ssaass=document.getElementById(vThisDotId);
  while(ssaass.childElementCount>6)
  {
  //alert("chla");
  ssaass.removeChild(ssaass.lastChild);
  }
  }
  // view and hide reply functionalities ends










  var replyButton=document.createElement('label');
  replyButton.style="font-weight: bold;color: skyblue;cursor: pointer;";
  replyButton.innerHTML="reply";
  var replyButtonId="replyButton"+pp;
  replyButton.setAttribute("id",replyButtonId);
  replyButton.onclick=function()
  {
  r=this.getAttribute("id");
  c=this.nextSibling.getAttribute("id");
  replyButtonClicked(c,r);
  };
  
 // body.appendChild(repliesCount);
  body.appendChild(viewReplies);
  body.appendChild(hideReplies);
  body.appendChild(replyButton);
  
  //comment form starts
  var commentForm=document.createElement('div');
  commentFormId="commentForm"+pp;
  commentForm.setAttribute("id",commentFormId);
  commentForm.style="display:none";
  var textarea=document.createElement('textarea');
  textarea.style="resize: none;border:none;";
  textarea.classList.add("form-control");
  textarea.setAttribute("rows",5);
  textareaId="comment"+pp;
  textarea.setAttribute("id",textareaId);
  textarea.setAttribute("name","comment");
  textarea.setAttribute("placeholder","write reply here..");
  var postCommentButton=document.createElement('button');
  postCommentButton.classList.add("btn");
  postCommentButton.classList.add("btn-primary"); 
  postCommentButton.style="margin-left: 3px;margin-top: 3px;";
  postCommentButton.innerHTML="post comment";
  postCommentButton.onclick=function()
  {
  t=this.previousSibling.id;
  cr=this.parentNode;
  c=cr.id;
  r=cr.previousSibling.id;
  b=cr.parentNode.id;
  postCommentButtonClicked(b,t,c,r);
 }
  var cancelButton=document.createElement('button');
  cancelButton.classList.add("btn");
  cancelButton.classList.add("btn-danger");
  cancelButton.style="margin-left: 3px;margin-top: 3px;";
  cancelButton.innerHTML="cancel";
  var cancelButtonId="cancelButton"+pp;
  cancelButton.setAttribute("id",cancelButtonId);
  cancelButton.onclick=function(){
  t=this.previousSibling.previousSibling.id;
  r=this.parentNode.previousSibling.id;
  c=this.parentNode.id;
  cancelButtonClicked(t,c,r);
  };
  commentForm.appendChild(textarea);
  commentForm.appendChild(postCommentButton);
  commentForm.appendChild(cancelButton);
  //comment form ends
  body.appendChild(commentForm);
  mask.appendChild(body);
  var space=document.createElement('hr');
  //space.style="height:15px";
  var x=document.getElementById(parent);
  x.appendChild(space); //for space between two division
  /*alert(x.firstChild);
  if(x.firstChild) x.prepend(mask);
  else x.appendChild(mask);
  //x.prepend(mask);
  //x.insertAdjacentElement('afterbegin', mask)*/
  x.appendChild(mask);
  function postCommentButtonClicked(bodyId,textareaId,commentFormId,replyButtonId)
  {
  t=document.getElementById(textareaId);
  createCommentBox(bodyId,t.value); 
   vUserIdFromSession=document.getElementById("logInInfo").innerHTML;
    addCommentReplies(t.value,vThisDotId,vUserIdFromSession,function(){
      loadReplies(vThisDotId);
      //current comment ko database me add karke loadReplies ko call ke liya
    });
  t.value="";
  $('#'+commentFormId).hide(500);
  $('#'+replyButtonId).css("display","block");

  }
  function replyButtonClicked(commentFormId,replyButtonId)
  {
  $('#'+commentFormId).show(500);
  $('#'+replyButtonId).css("display","none");
  }
  function cancelButtonClicked(textareaId,commentFormId,replyButtonId)
  {
  document.getElementById(textareaId).value="";
  $('#'+commentFormId).hide(500);
  $('#'+replyButtonId).css("display","block");
  }
  }
   


function addCommentReplies(vContent,vParentId,vUserId,successCallBack)
  {
var commentJSON={
"id": 0,
"content" : vContent,
"parentId": vParentId,
"userId" : vUserId,
"time": null
};

var httpRequest=new XMLHttpRequest();
httpRequest.onreadystatechange=function(){
if(this.readyState==4 &&  this.status==200)
{ 
var applicationResponse=JSON.parse(httpRequest.responseText);

var e=applicationResponse.result;
//var employee=new Employee(e.code,e.firstName,e.lastName,e.gender,e.isPermanent,e.city);
//successCallBack(employee);
successCallBack();
//window.location.replace("/skillshare/postDetails.jsp?threadId="+vParentId+"&userId="+vUserId);
}};
httpRequest.open("POST","addComment",true);
httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
httpRequest.send(JSON.stringify(commentJSON));
}



function loadReplies(parentId)
{
//alert(parentId);
ssaass=document.getElementById(parentId);
//alert(ssaass.childNodes.count);
//alert(ssaass.childElementCount);
while(ssaass.childElementCount>6)
{
  //alert("chla");
  ssaass.removeChild(ssaass.lastChild);
}

var loadRepliesJSON={
"threadId":parentId
};
//alert(parentId);
var httpRequest=new XMLHttpRequest();
httpRequest.onreadystatechange=function(){
if(this.readyState==4 && this.status==200)
{
var data=httpRequest.responseText;
var applicationResponse=JSON.parse(data);
//var threads=[];
var jsonThreadComments=applicationResponse.comments;
var l=jsonThreadComments.length;
//alert(l);
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
  createCommentBox(parentId,threadCommentContent,threadCommentCreatedDate,commentUserProfile,commentUserName,threadCommentId);
 //isi ko call kiya nested
 //alert(parentId+" "+threadCommentId+" "+threadCommentContent+" "+threadCommentCreatedDate+" "+commentUserProfile+" ");
}

}
}
;
httpRequest.open("POST","getReplies",true);
httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
httpRequest.send(JSON.stringify(loadRepliesJSON));
//why this is not a request of type GET
}
