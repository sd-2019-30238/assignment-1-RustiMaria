<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>

	<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Register</h3>

	<p style="color: red;">${errorString}</p>

	<form method="POST"
		action="${pageContext.request.contextPath}/register">
		<table border="0">
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" value="${client.firstName}" />
				</td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" value="${client.lastName}" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td><input type="text" name="address" value="${client.address}" />
				</td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" value="${client.email}" /></td>
			</tr>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" value="${user.username}" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value="${user.password}" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="${pageContext.request.contextPath}/">Cancel</a></td>
			</tr>
		</table>
	</form>

</body>
</html>