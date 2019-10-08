	function createPost()
	{
alert("chala");
	var pp=makeid(5);	
var postMask=document.createElement('div');
		postMaskId="postMask"+pp;
		postMask.setAttribute('id',postMaskId);
		postMask.classList.add('container');
	var postHeading=document.createElement('h4');
		postHeading.classList.add('heading');
		postHeading.innerHTML="Responsive Text Use the  unit when sizing the text. 10vw will set the size to 10% of the viewport width.";
	var userDetails=document.createElement('div');
		userDetails.classList.add('row');
		var userProfile=document.createElement('img');
			userProfile.classList.add('rounded-circle');
			userProfile.classList.add('ml-3');
			userProfile.style="width: 70px; height: 70px;";
			userProfile.src="khandelwal.png";
		var userNameSection=document.createElement('div');
			userNameSection.classList.add('ml-1');
			userNameSection.classList.add('mt-2');
			var nameOfUser=document.createElement('p');
				nameOfUser.style="margin-bottom: 0px;font-family: cursive;";
				nameOfUser.innerHTML="Sandeep Acharya";
			var timeOfPost=document.createElement('p');
				timeOfPost.style="margin-top: 0px";
				timeOfPost.innerHTML="july 19,2019";
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
			postImage1.src="abc.jpg"; //dynamic
			postImage1.alt="";
		postImageSection.appendChild(postImage1);

	var postContent=document.createElement('p');
		postContent.classList.add('content');
		postContent.style="white-space: pre-wrap"; //for preserving new lines
		postContent.innerHTML="vbkknbdjkjhjkjhjk";

	var commentCountSection=document.createElement('label');
		commentCountSection.style="font-weight: bold;color: #56051a;white-space: pre-wrap";
		commentCountSection.innerHTML="Comments  "+"somevariable";

	var replyButton=document.createElement('label');
	replyButton.style="font-weight: bold;color: skyblue;cursor: pointer;float:right";
	replyButton.innerHTML="Click Here To Leave a Reply";
	var replyButtonId="replyButton"+pp;
	replyButton.setAttribute("id",replyButtonId);
	replyButton.onclick=function()
        {
        commentFormId=this.nextSibling.getAttribute("id"); //means commentForm reply button ka next sibling comment form he
        	$('#'+commentFormId).show(500);
          	this.style="display:none";
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
		t=this.previousSibling.id;
		cr=this.parentNode;
		c=cr.id;
		r=cr.previousSibling.id;
		b=cr.parentNode.id; //post id to which comments are appended
		postCommentButtonClicked(b,t,c,r); //function to appendComments

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
	function postCommentButtonClicked(postId,textareaId,commentFormId,replyButtonId)
	{
		
		t=document.getElementById(textareaId);
		createCommentBox(postId,t.value);
		t.value="";
      $('#'+commentFormId).hide(500);
      document.getElementById(replyButtonId).style="display:block;font-weight: bold;color: skyblue;cursor: pointer;float:right";
	}
	function cancelButtonClicked(textareaId,commentFormId,replyButtonId)
	{
		document.getElementById(textareaId).value="";
      $('#'+commentFormId).hide(500);
      document.getElementById(replyButtonId).style="display:block;font-weight: bold;color: skyblue;cursor: pointer;float:right";
	}
//comment Form ends
postMask.appendChild(commentForm);
var parent=document.getElementById("postSection");
parent.appendChild(postMask);
parent.style.display="block";
}