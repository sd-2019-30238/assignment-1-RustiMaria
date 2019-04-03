<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>Admin Task</title>
</head>

<body style="background-color: LightGray;">

	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Admin Task</h3>

	Hello, you are logged in as admin!
		
	<br>
	<br>

	<form method="POST" action="${pageContext.request.contextPath}/adminTask">
	
	<input type="submit" name="add" value="Add Product">
	<input type="submit" name="update" value="Update Product">
	<input type="submit" name="delete" value="Delete Product">
	
	</form>

</body>
</html>