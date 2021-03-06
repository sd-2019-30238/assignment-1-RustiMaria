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
				<td>Name</td>
				<td><input type="text" name="productName"
					value="${product.name}" required /></td>
			</tr>
			<tr>
				<td>Price</td>
				<td><input type="number" name="productPrice"
					value="${product.price}" min = '0' required /></td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="number" name="productQuantity"
					value="${product.quantity}" min = '1' required /></td>
			</tr>
			<tr>
				<td>Discount</td>
				<td><select name = "discount" value="${product.discountid}">
					<option value="holiday">holiday - 15%</option>
					<option value="season">season - 23%</option>
					<option value="ten">tenPercent - 10%</option>
					<option value="none">none</option>
				</select></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" name="addProduct" value="Add">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>