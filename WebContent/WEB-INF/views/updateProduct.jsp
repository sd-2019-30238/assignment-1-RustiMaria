<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
</head>
<body style="background-color: LightGray;">

	<jsp:include page="_menu.jsp"></jsp:include>
	<form method="POST" action="${pageContext.request.contextPath}/tasks">

		<table border="0">
			<tr>
				<td>The id of the product you want to update:</td>
				<td><input type="number" name="idProduct" min = '1' required></td>
			</tr>
			<tr>
				<td>The field you want to update:</td>
				<td><select name = "field">
					<option value="name" selected>Name</option>
					<option value="price">Price</option>
					<option value="quantity">Quantity</option>
					<option value="discountId">Discount</option>
					</select></td>
			</tr>
				<tr>
					<td>New value:</td>
					<td><input type="text" name="newValue" required></td>
				</tr>
			<tr>
				<td colspan="2"><input type="submit" name="updateProduct" value="Update">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>