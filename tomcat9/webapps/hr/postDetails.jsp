<!DOCTYPE html>
<html>
  <head>
    <title>
    </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js">
    </script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js">
    </script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js">
    </script>
    <script src="js/postBox.js">
    </script>
    <script src="js/commentBox.js">
    </script>
    <link rel="stylesheet" type="text/css" href="css/postBox.css">
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
        createPost();
      }
      window.addEventListener('load',initialize);
    </script>
  </head>
  <body>
    <jsp:include page="myHeader.jsp" />
    <!--post Description-->
    <div id="postSection" class="container-fluid" style="padding-bottom: 30px;display: none;left: 0px; top: 0px; position: relative; width:100%; height: 100%;background-color:white;opacity: .9;margin-top: 20px">
    </div>
    <!--post Description-->
    <!-- Footer section add later -->
    <!-- Footer -->
  </body>
</html>
