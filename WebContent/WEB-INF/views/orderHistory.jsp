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

<style>
.slidecontainer {
	width: 100%;
}

.slider {
	-webkit-appearance: none;
	width: 100%;
	height: 25px;
	background: #d3d3d3;
	outline: none;
	opacity: 0.7;
	-webkit-transition: .2s;
	transition: opacity .2s;
}

.slider:hover {
	opacity: 1;
}

.slider::-webkit-slider-thumb {
	-webkit-appearance: none;
	appearance: none;
	width: 25px;
	height: 25px;
	background: #4CAF50;
	cursor: pointer;
}

.slider::-moz-range-thumb {
	width: 25px;
	height: 25px;
	background: #4CAF50;
	cursor: pointer;
}
</style>
</head>

<body style="background-color: LightGray;">

	<jsp:include page="_menu.jsp"></jsp:include>
	<form method="POST"
		action="${pageContext.request.contextPath}/orderHistory">
		<br>
		<table id="t01">
			<tr>
				<th>Total</th>
				<th>Status</th>
				<th>Feedback</th>
			</tr>
			<c:forEach items="${orders}" var="order">
				<tr>
					<td><c:out value="${order.total}" /></td>
					<td><c:out value="${order.status}" /></td>
					<td><div class="slidecontainer">
							<p>From 1 to 100, please tell us how satisfied are you with our services regarding this order?</p>
							<input type="range" min="1" max="100" value="50"></div></td>
				</tr>
			</c:forEach>
		</table>
	</form>

</body>
</html>