<%@page import="Model.Bean.*"%>
<%@page import="Model.Bean.CardBean"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<style>
body {
	font-size: 16px;
	margin: 0;
	font-family: "Lato", sans-serif;
}

.sidebar {
	margin: 0;
	padding: 0;
	width: 200px;
	background-color: #f1f1f1;
	position: fixed;
	height: 100%;
	overflow: auto;
}

.sidebar a {
	display: block;
	color: black;
	padding: 16px;
	text-decoration: none;
}

.sidebar a.active {
	background-color: #04AA6D;
	color: white;
}

.sidebar a:hover:not(.active) {
	background-color: #555;
	color: white;
}

div.content {
	margin-left: 200px;
	padding: 1px 16px;
	height: 1000px;
}

@media screen and (max-width: 700px) {
	.sidebar {
		width: 100%;
		height: auto;
		position: relative;
	}
	.sidebar a {
		float: left;
	}
	div.content {
		margin-left: 0;
	}
}

@media screen and (max-width: 400px) {
	.sidebar a {
		text-align: center;
		float: none;
	}
}

.content-header {
	display: flex;
	flex-direction: row;
	justify-content: space-between;
	align-items: center;
	margin-bottom: 10px;
}

.content-header img {
	width: 50px;
	height: 50px;
	object-fit: cover;
}

.content-ads img {
	padding: 10%;
	width: 100%;
	height: 100%;
}

.row-btn {
	display: flex;
	padding: 10px;
}

.btn-inline {
	width: 50%;
}

.form-group {
	margin-bottom: 10px
}
</style>
</head>
<body>
	<div class="container">
		<div class="sidebar">
			<a class="active" href="#home">Home</a> <a href="AddController">Add
				new Laptop</a> <a href="ViewController?modViewLaptop=1">Show all
				Laptops</a> <a href="UpdateController?modUpdateLaptop=1">Update</a> <a
				href="DeleteController?modDeleteLaptop=1">Delete</a> <a href="#">Search</a>
				<a href="Login.jsp">Logout</a>

		</div>
		<div class="content">
			<div class="content-header">
				<img
					src="http://dut.udn.vn/Files/admin/images/Tin_tuc/Khac/2020/LogoDUT/image002.jpg"
					alt="">
				<div class="h3">Quan Ly Cua Hang Laptop</div>
				<div class="div"></div>
			</div>

			<form action="AddController" method="post">
				<%
				LaptopBean lap = (LaptopBean) request.getAttribute("lapUpdate");
				%>
				<div class="form-group row">
					<label for="lapId" class="col-sm-2 col-form-label">ID
						Laptop</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="lapId" id="lapId"
							value="">
					</div>
				</div>
				<div class="form-group row">
					<label for="lapName" class="col-sm-2 col-form-label">Laptop's
						name</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" name="lapName"
							id="lapName" value="">
					</div>
				</div>
				<div class="form-group row">
					<label for="companyId" class="col-sm-2 col-form-label">Company'name</label>
					<div class="col-sm-10">

						<select name="companyId" class="form-control">

							<%
							ArrayList<CompanyBean> compList = (ArrayList<CompanyBean>) request.getAttribute("compList");
							for (int i = 0; i < compList.size(); i++) {
							%>
							<option value="<%=compList.get(i).getCompanyId()%>"><%=compList.get(i).getCompanyName()%></option>
							<%
							}
							%>
						</select>
					</div>
				</div>
				<div class="form-group row">
					<label for="cardId" class="col-sm-2 col-form-label">Company'name</label>
					<div class="col-sm-10">

						<select name="cardId" class="form-control">
							<%
							ArrayList<CardBean> cardList = (ArrayList<CardBean>) request.getAttribute("cardList");
							for (int i = 0; i < cardList.size(); i++) {
							%>
							<option value="<%=cardList.get(i).getCardId()%>"><%=cardList.get(i).getCardName()%></option>

							<%
							}
							%>
						</select>
					</div>
				</div>



				<div class="form-group row">
					<label for="aoumt" class="col-sm-2 col-form-label">Amount</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" name="amount"
							id="amount" value="">
					</div>
				</div>
				<div class="form-group row">
					<label for="price" class="col-sm-2 col-form-label">Price</label>
					<div class="col-sm-10">
						<input type="number" class="form-control" name="price" id="price"
							value="%>">
					</div>
				</div>

				<div class="form-group row row-btn">
					<div class="col-sm-10 btn-inline">
						<input type="submit" class="btn btn-primary" name="btnAddLaptop"
							value="Add">
					</div>
					<div class="col-sm-10 btn-inline">
						<input type="reset" class="btn btn-danger" name="btnreset"
							value="Reset">
					</div>
				</div>

			</form>
		</div>
	</div>
</body>
</html>