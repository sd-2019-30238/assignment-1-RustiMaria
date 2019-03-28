<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>User Info</title>
   </head>
   <body style="background-color:LightGray;">
 
     <jsp:include page="_menu.jsp"></jsp:include>
 
      <h3>Hello, ${logedInUser.username}</h3>
 
      <br /> 
 
   </body>
</html>