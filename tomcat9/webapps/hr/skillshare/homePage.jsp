<!DOCTYPE html>
<html>
  <head>
    <title>
    </title>
	<jsp:include page="library.jsp" />
<script>
function setupView()
{
alert("load hua");
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
        <marquee id="frequentlyAskedQuestions" direction="up"  style="background-color: #8f1edb;height: 300px" onmouseover="this.stop()" onmouseout="this.start()">
          
            <div class="container" style="min-height: 50px;background-color:white; font-weight: bold;margin-right: 2px;border: 1px solid green;border-radius: 30px;">
              <a href="/skillshare/postDetails.jsp" style="word-wrap: break-word;cursor: pointer;">What are constructors in Java?
              </a>
          </div>
          <div id="space" style="min-height: 15px"></div>



   <div class="container" style="min-height: 50px;background-color:white; font-weight: bold;margin-right: 2px;border: 1px solid green;border-radius: 30px;">
              <a style="word-wrap: break-word;cursor: pointer;">What is the difference between Array list and vector?
              </a>
          </div>
          <div id="space" style="min-height: 15px"></div>
   <div class="container" style="min-height: 50px;background-color:white; font-weight: bold;margin-right: 2px;border: 1px solid green;border-radius: 30px;">
              <a style="word-wrap: break-word;cursor: pointer;">What is the difference between equals() and == ?

              </a>
          </div>
          <div id="space" style="min-height: 15px"></div>



        </marquee>
        </div>
        


        <div class="col-sm-7" >
        	<h5 style="background-color: #050621;color: white;padding: 12px;">Recent Posts</h5>
       
        
        <div class="col-sm-12" style="background-color:#ed9393;height: auto;padding-top: 1px">

          <div class="row" style="border: 1px solid green;border-radius: 25px;background-color: white;opacity: .9">
            <div class="col-sm-2" style="height:auto;">
              <CENTER>
                <img src="abc.jpg" style="height: 8rem;width: 8rem;" class="rounded img-fluid">
              </CENTER>
            </div>
            <div class="col-sm-10" style="min-height: 50px;padding:3px">
              <p style="width: 100%;word-wrap: break-word;font-weight: bold;font-size: 21px">  steps to connect to a database in java?</p>
              <P style="width: 100%;word-wrap: break-word;margin-top: 3px;font-style: italic;font-size: 18px"> Registering the driver class
              Creating connection
              Creating statement
              Executing queries
              Closing connection

            </P>
              <a href="/skillshare/postDetails.jsp">read more...
              </a>
            </div>
          </div>
          <div id="space" style="min-height: 5px"> </div>

          <div class="row" style="border: 1px solid green;border-radius: 25px;background-color: white;opacity: .9">
            <div class="col-sm-2" style="height:auto;">
              <CENTER>
                <img src="abc.jpg" style="height: 8rem;width: 8rem;" class="rounded img-fluid">
              </CENTER>
            </div>
            <div class="col-sm-10" style="min-height: 50px;padding:3px">
              <p style="width: 100%;word-wrap: break-word;font-weight: bold;font-size: 21px"> DBC Connection interface?</p>
              <P style="width: 100%;word-wrap: break-word;margin-top: 3px;font-style: italic;font-size: 18px"> The Connection interface maintains a session with the database. It can be used for transaction management. It provides factory methods that returns the instance of Statement, PreparedStatement, CallableStatement and DatabaseMetaData.
              </P>
              <a href="">read more...
              </a>
              <label style="margin-left: 50%">on 15 5 2019 18:55 am</label>
            </div>
          </div>
          <div id="space" style="min-height: 5px"> </div>


        </div>
        </div>

      	<div class="col-sm-2">
      		<h5 style="background-color: #050621;color: white;padding: 12px">Topics</h5>
        
      	<div id="frequentlyAskedQuestions" style="background-color: #8f1edb;height: auto;padding-top: 5px">
           
           	<div style="border: 1px solid green;border-radius: 10px;background-color: white;margin-right: 1px;margin-left: 1px;padding:5px;font-weight: bold ">
              <a style="word-wrap: break-word;cursor: pointer;">Database
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
