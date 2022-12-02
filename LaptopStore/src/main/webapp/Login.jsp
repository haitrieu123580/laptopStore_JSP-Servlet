<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {
	width: 400px;
	margin: 0px auto;
}

caption {
	margin: 5px 10px;
}

td {
	padding: 3px 20px;
}
</style>
</head>
<body>

	<form action="CheckLoginController" method="POST">
		<table>
			<tr>
				<caption>Dang nhap</caption>
			</tr>
			<tr>
				<td><label for="username">Username</label></td>
				<td><input type="text" name="username" value="" id=username>
				</td>
			</tr>
			<tr>
				<td><label for="password">Password</label></td>
				<td><input type="password" name="password" value=""
					id="password"></td>
			</tr>
			<tr>
				<td><input type="submit" name="btn-login" value="login">

				</td>
				<td><input type="reset" name="btn-reset" value="Reset">
				</td>
				<td></td>
			</tr>
		</table>


	</form>
</body>
</html>