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
				<td>The id of the order you want to update:</td>
				<td><input type="number" name="idOrder" min = '1' required></td>
			</tr>
			<tr>
				<td>The new status of the order:</td>
				<td><select name = "status" value="${order.status}">
					<option value="processed">Processed</option>
					<option value="delivered">Delivered</option>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="orderStatus" value="Update">
				</td>
			</tr>
		</table>

	</form>
</body>
</html>