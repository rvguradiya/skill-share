function createCommentBox(parent,msg)
  {
  var pp=makeid(5);	
  //var r = Math.random().toString(36).substring(5);
  var mask=document.createElement("div");
  mask.classList.add("media");
  mask.classList.add("p-3");
  var profile=document.createElement('img');
  profile.setAttribute("src","khandelwal.png");
  profile.style="width:70px;height:70px";
  profile.classList.add('rounded-circle');
  mask.appendChild(profile);
  var body=document.createElement('div');
  body.classList.add("media-body");
  var bodyId="b"+pp;
  body.setAttribute("id",bodyId);
  var heading=document.createElement('h6');
  heading.innerHTML="Sandeep Acharya says : ";
  heading.style="margin-top:5px;font-style:oblique"
  var time=document.createElement('label');
  time.innerHTML="posted on : "+"19 feb 2019";
  time.style="color:#8e97a5;white-space: pre-wrap;float: right;font-size: small;";
  heading.appendChild(time);
  body.appendChild(heading);
  var content=document.createElement('p');
  content.innerHTML=msg;
  content.style="font-family:Times New Roman, Times, serif;white-space: pre-wrap;";
  body.appendChild(content);
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
  // view and hide reply functionalities starts
  var i=document.createElement('i')
  i.innerHTML="View Replies";
  replyButton.appendChild(i);
  // view and hide reply functionalities ends
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
   
