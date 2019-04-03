<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<style>
table {
	width: 100%;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 15px;
	text-align: left;
}

table#t01 tr:nth-child(even) {
	background-color: #eee;
}

table#t01 tr:nth-child(odd) {
	background-color: #fff;
}

table#t01 th {
	background-color: black;
	color: white;
}
</style>

<title>Furniture Deals</title>
</head>

<body style="background-color: LightGray;">
	<jsp:include page="_menu.jsp"></jsp:include>
	<form method="POST"
		action="${pageContext.request.contextPath}/listProducts">
		<br>
		<table id="t01">
			<tr>
				<th>Name</th>
				<th>Price ($)</th>
				<th>Quantity</th>
				<th>Discount (%)</th>
				<th>Buy it</th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td><c:out value="${product.name}"/></td>
					<td><c:out value="${product.price}" /></td>
					<td><c:out value="${product.quantity}" /></td>
					<td><c:out value="${product.discountId}" /></td>
					<td colspan="2"><input type="submit" name="buy" value="Buy"></td>
				</tr>
			</c:forEach>
		</table>
		<br>
		<br>
		<table>
			<tr>
				<td>Filter by:</td>
				<td><select name="type">
						<option value="priceUp" selected>Ascendent Price</option>
						<option value="priceDown">Descendent Price</option>
						<option value="discount">With Discount</option>
				</select></td>
				<td colspan="2"><input type="submit" name="filter"
					value="Filter"></td>
			</tr>
		</table>

	</form>

</body>
</html>