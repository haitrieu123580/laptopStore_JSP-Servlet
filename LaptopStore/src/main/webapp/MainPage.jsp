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
          .sidebar a {float: left;}
          div.content {margin-left: 0;}
        }
        
        @media screen and (max-width: 400px) {
          .sidebar a {
            text-align: center;
            float: none;
          }
        }
        .content-header{
          
          display: flex;
    flex-direction: row;
    justify-content: space-between;
    align-items: center;
        }
        .content-header img{
          width: 50px;
          height: 50px;
          object-fit: cover;
        }
        .content-ads img{
          padding: 10%;
          width: 100%;
          height: 100%;
        }
        </style>
</head>
<body>
    <div class="container">
        
        <div class="sidebar">
          <a class="active" href="#home">Home</a>
          <a href="AddController?modAddLaptop=1">Add new Laptop</a>
          <a href="ViewController?modViewLaptop=1">Show all Laptops</a>
          <a href="UpdateController?modUpdateLaptop=1">Update</a>
          <a href="DeleteController?modDeleteLaptop=1">Delete</a>
          <a href="SearchController?modSearchLaptop=1">Search</a>
		<a href="Login.jsp">Logout</a>
        </div>
        <div class="content">
          <div class="content-header">
            <img src="http://dut.udn.vn/Files/admin/images/Tin_tuc/Khac/2020/LogoDUT/image002.jpg" alt="">
            <div class="h3">Quan Ly Cua Hang Laptop</div>
            <div class="div"></div>
          </div>
          <div class="content-ads">
            <img src="https://dlcdnwebimgs.asus.com/gain/C263B5D7-FDA7-46D8-BC33-A65C81E4DC93/fwebp " alt="">
            <img src="https://storage-asset.msi.com/global/picture/news/2020/case/ces-20200103-4.jpg" alt="">
          </div>
        </div>
    </div>
</body>
</html>