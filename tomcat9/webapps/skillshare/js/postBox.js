	
function createPost(vPostId,vUserId,vHeading,vContent,vCreatedAt,vImage,vUserName,vUSerProfile,commentCount)
	{
//alert(q+" "+a);

	var pp=makeid(5);	
var postMask=document.createElement('div');
		postMaskId=vPostId;
		postMask.setAttribute('id',postMaskId);
		postMask.classList.add('container');
	var postHeading=document.createElement('h4');
		postHeading.classList.add('heading');
		postHeading.innerHTML=vHeading;
		var userDetails=document.createElement('div');
		userDetails.classList.add('row');
		var userProfile=document.createElement('img');
			userProfile.classList.add('rounded-circle');
			userProfile.classList.add('ml-3');
			userProfile.style="width: 70px; height: 70px;";
			userProfile.src=vUSerProfile;
		var userNameSection=document.createElement('div');
			userNameSection.classList.add('ml-1');
			userNameSection.classList.add('mt-2');
			var nameOfUser=document.createElement('p');
				nameOfUser.style="margin-bottom: 0px;font-family: cursive;";
				nameOfUser.innerHTML=vUserName;
			var timeOfPost=document.createElement('p');
				timeOfPost.style="margin-top: 0px";
				timeOfPost.innerHTML=vCreatedAt;
			userNameSection.appendChild(nameOfUser);
			userNameSection.appendChild(timeOfPost);
		userDetails.appendChild(userProfile);
		userDetails.appendChild(userNameSection);
	var postImageSection=document.createElement('div');
		userDetails.classList.add('row');
		var postImage1=document.createElement('img');
			postImage1.classList.add('mx-auto'); //for centered image
			postImage1.classList.add('d-block');//for display block
			postImage1.classList.add('img-fluid');//for responsive image
			postImage1.src=vImage; //dynamic
			postImage1.alt="";
		postImageSection.appendChild(postImage1);

	var postContent=document.createElement('p');
		postContent.classList.add('content');
		postContent.style="white-space: pre-wrap"; //for preserving new lines
		postContent.innerHTML=vContent;
	var commentCountSection=document.createElement('label');
		commentCountSection.style="font-weight: bold;color: #56051a;white-space: pre-wrap";
		commentCountSection.innerHTML="Comments : "+commentCount;
		//+"somevariable"

	var replyButton=document.createElement('label');
	replyButton.style="font-weight: bold;color: #0a0a0a;cursor: pointer;float:right";
	replyButton.innerHTML="Click Here To Leave a Reply";
	var replyButtonId="replyButton"+pp;
	replyButton.setAttribute("id",replyButtonId);
	replyButton.onclick=function()
        {
        	if(document.getElementById('logInInfo').innerHTML=='null')
        	{
        		alert("Login to reply");
        		return;
        	}
        commentFormId=this.nextSibling.getAttribute("id"); //means commentForm reply button ka next sibling comment form he
        	$('#'+commentFormId).show(100);
          	this.style="display:none";
         
         //alert(commentForm.firstChild.id);
         //commentFormId.firstChild.focus;
		}

postMask.appendChild(postHeading);
postMask.appendChild(userDetails);
postMask.appendChild(postImageSection);
postMask.appendChild(postContent);
postMask.appendChild(commentCountSection);
postMask.appendChild(replyButton);
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
		textarea=this.previousSibling.id;
		commentContent=document.getElementById(textarea).value;
		cr=this.parentNode;
		var cId=cr.id; //comment formId
		
		replyButtonId=cr.previousSibling.id; //replyButton id
		//parentId=cr.parentNode.id; //post id to which comments are appended
		//alert(cr+"   this is  "+b)
		//postCommentButtonClicked(b,t,c,r); //function to appendComments

		vUserIdFromSession=document.getElementById("logInInfo").innerHTML;
		
		addComment(commentContent,vPostId,vUserIdFromSession,function(vComment){
		createCommentBox(vComment.parentId,vComment.content,vComment.time,vComment.userName);
		document.getElementById(textarea).value="";
     	 $('#'+cId).hide(100);
      	document.getElementById(replyButtonId).style="display:block;font-weight: bold;color: skyblue;cursor: pointer;float:right";
		});


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
    }
	commentForm.appendChild(textarea);
	commentForm.appendChild(postCommentButton);
	commentForm.appendChild(cancelButton);
	
	function cancelButtonClicked(textareaId,commentFormId,replyButtonId)
	{
		document.getElementById(textareaId).value="";
      $('#'+commentFormId).hide(100);
      //alert(commentFormId)
      document.getElementById(replyButtonId).style="display:block;font-weight: bold;color: skyblue;cursor: pointer;float:right";
	}
//comment Form ends
postMask.appendChild(commentForm);
var parent=document.getElementById("postSection");
parent.appendChild(postMask);
parent.style.display="block";
}


function addComment(vContent,vParentId,vUserId,successCallBack)
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
//alert(e);
//var employee=new Employee(e.code,e.firstName,e.lastName,e.gender,e.isPermanent,e.city);
//successCallBack(employee);
//successCallBack();
window.location.replace("/skillshare/postDetails.jsp?threadId="+vParentId+"&userId="+vUserId);
}};
httpRequest.open("POST","addComment",true);
httpRequest.setRequestHeader("content-type","application/x-www-form-urlencoded");
httpRequest.send(JSON.stringify(commentJSON));
}
