<!DOCTYPE html>
<html>
<head>
	<title></title>
	 <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>

<script type="text/javascript">
	function makeid( length ) {
    
    var str = "";
    for ( ; str.length < length; str += Math.random().toString( 36 ).substr( 2 ) );
    return str.substr( 0, length );
}
</script>
<script type="text/javascript">
	function createBox(parent)
	{
		var pp=makeid(5);
			//var r = Math.random().toString(36).substring(5);
	var mask=document.createElement("div");
	mask.classList.add("media");
	mask.classList.add("p-3");
	//mask.classList.add("border");
	var profile=document.createElement('img');
	profile.setAttribute("src","khandelwal.png");
	profile.style="width:60px";
	profile.classList.add('rounded-circle');
	mask.appendChild(profile);
	var body=document.createElement('div');
	body.classList.add("media-body");
	var bodyId="b"+pp;
	body.setAttribute("id",bodyId);
	var heading=document.createElement('h4');
	heading.innerHTML="John DoeLorem ipsum dolor sit ametLorem ipsum dolor sit ametLorem ipsum dolor sit ametLorem ipsum color sit amet";
	var time=document.createElement('small');
	time.innerHTML="posted on";
	var date=document.createElement('i');
	date.innerHTML="19 feb 2019";
	time.appendChild(date);
	heading.appendChild(time);
	body.appendChild(heading);
	var content=document.createElement('p');
	content.innerHTML="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
	body.appendChild(content);
	var replyButton=document.createElement('label');
	replyButton.style="font-weight: bold;color: skyblue;cursor: pointer;";
	replyButton.innerHTML="reply";
	var replyButtonId="replyButton"+pp;
	replyButton.setAttribute("id",replyButtonId);
	replyButton.onclick=function()
        {
          $('#'+commentFormId).show(500);
          $('#'+replyButtonId).css("display","none");
        };
	body.appendChild(replyButton);
	//comment form
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
		createBox(bodyId);
		document.getElementById(textareaId).value="";
      $('#'+commentFormId).hide(500);
      $('#'+replyButtonId).css("display","block");

	}
	var cancelButton=document.createElement('button');
	cancelButton.classList.add("btn");
	cancelButton.classList.add("btn-danger");
	cancelButton.style="margin-left: 3px;margin-top: 3px;";
	cancelButton.innerHTML="cancel";
	var cancelButtonId="cancelButton"+pp;
	cancelButton.setAttribute("id",cancelButtonId);
	cancelButton.onclick=function(){
      document.getElementById(textareaId).value="";
      $('#'+commentFormId).hide(500);
      $('#'+replyButtonId).css("display","block");

    };
	commentForm.appendChild(textarea);
	commentForm.appendChild(postCommentButton);
	commentForm.appendChild(cancelButton);

	//comment form
	body.appendChild(commentForm);
	mask.appendChild(body);

	var space=document.createElement('div');
	space.style="height:15px";
	var x=document.getElementById(parent);
	x.appendChild(space);
	x.appendChild(mask);

	}
</script>
</head>
<body>



<div class="container mt-3 border" id="x">
   
  </div>
 


<a href="javascript:createBox('x')">create</a>
</body>
</html>