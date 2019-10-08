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
      <input class="form-control mr-sm-2" type="search" placeholder="Search">
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
    <ul class="navbar-nav  col-sm-2 " style="margin-left: 80%">
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
      <li class="navbar-nav pull-right">
        <a class="nav-link" href="#"    data-toggle="modal" data-target="#myModal">Add_Article
        </a>
      </li>
      <li class="navbar-nav pull-right">
        <a class="nav-link" href="#"    data-toggle="modal" data-target="#askQuestionModal">Ask_Question
        </a>
      </li>
    </ul>


    <ul class="navbar-nav  col-sm-2" >
      <img src="user-icon.png" style="width: 50px;height: 50px;margin-left: 50px" class="rounded-circle">
      <li class="nav-link">
        <button style="background-color: #e80d65;color: white;cursor: pointer;" ><%=session.getAttribute("username")%>
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
<!--navbar-->
<!--header-->



