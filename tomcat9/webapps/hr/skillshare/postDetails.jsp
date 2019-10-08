<!DOCTYPE html>
<html>
  <head>
    <title>
    </title>
	<jsp:include page="library.jsp" />
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
       

        q="What are constructors in Java?";
        a="In Java, constructor refers to a block of code which is used to initialize an object. It must have the same name as that of the class. Also, it has no return type and it is automatically called when an object is created.There are two types of constructors:Default constructor Parameterized constructor";

     createPost();
      }
      window.addEventListener('load',initialize);
    </script>
  </head>
  <body>
    <!--include header-->
    <jsp:include page="myHeader.jsp"/>
    

    <!--post Description-->
    <div id="postSection" class="container-fluid" style="padding-bottom: 30px;display: none;left: 0px; top: 0px; position: relative; background-color:white;opacity: .9;margin-top: 20px">
    </div>
    <!--post Description-->


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

