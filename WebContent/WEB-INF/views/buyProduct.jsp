<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Buy Product</title>
</head>
<body style="background-color: LightGray;">

	<jsp:include page="_menu.jsp"></jsp:include>
	<form method="POST" action="${pageContext.request.contextPath}/buy">

		<table border="0">
			<tr>
				<td>The id of the product you want to buy:</td>
				<td><input type="text" name="idProduct"></td>
			</tr>
			<tr>
				<td>Quantity:</td>
				<td><input type="text" name="quantity"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="buy" value="Add to cart">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>