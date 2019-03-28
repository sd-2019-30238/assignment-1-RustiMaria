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

	<a href="${pageContext.request.contextPath}/tasks" class="btn btn-info" role="button">Add Product</a>
	<a href="${pageContext.request.contextPath}/tasks" class="btn btn-info" role="button">Update Product</a>
	<a href="${pageContext.request.contextPath}/tasks" class="btn btn-info" role="button">Delete Product</a>
	<a href="${pageContext.request.contextPath}/tasks" class="btn btn-info" role="button">Add Discount</a>
	<a href="${pageContext.request.contextPath}/tasks" class="btn btn-info" role="button">Update Discount</a>
	
	<input type="submit" name="add" value="Add Product">
	<input type="submit" name="update" value="Update Product">
	
	</form>

</body>
</html>