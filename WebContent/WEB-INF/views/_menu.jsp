<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  margin: 0;
  font-family: Arial, Helvetica, sans-serif;
}

.topnav {
  overflow: hidden;
  background-color: #333;
}

.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
}

.topnav a.active {
  background-color: #4CAF50;
  color: white;
}
</style>
</head>
<body>

<div class="topnav">
  <a class="active" href="${pageContext.request.contextPath}/"> Home </a>
  <a href="${pageContext.request.contextPath}/listProducts"> View Products </a>
  <a href="${pageContext.request.contextPath}/login"> Login </a>
  <a href="${pageContext.request.contextPath}/admin"> Admin Login </a>
  <a href="${pageContext.request.contextPath}/logout"> Logout </a>
  <a href="${pageContext.request.contextPath}/register"> Register </a>
  <a href="${pageContext.request.contextPath}/cart"> Cart </a>
  <a href="${pageContext.request.contextPath}/orderHistory"> Order History </a>
</div>

</body>
</html>
