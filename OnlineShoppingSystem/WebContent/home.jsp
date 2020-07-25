<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
* {box-sizing: border-box}
	body {font-family: "Lato", sans-serif;
	
	}

.tab {
  float:none;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
  width: 100%;
  height: 1000%;
  
}

.tab button {
  display: block;
  background-color: inherit;
  color: black;
  padding: 22px 16px;
  width: 100%;
  border: 10mm;
  outline: none;
  text-align: center;
  cursor: pointer;
  font-size: 17px;
}

.tab button:hover {
  background-color: #ddd;
}

.tab button.active {
  background-color: #ccc;
}

a:link {
  text-decoration: none;
}

h1{
	text-align:center;
	color:white;
	background-color: green;
	height:40px;
}


</style>
<body bgcolor="cyan">
			<h1>Online Shopping system</h1>

			<div class="tab" style="align=center;">
				<a href="AdminLogin.jsp"><button>Admin Login</button></a>
				<a href="customerlogin.jsp"><button>User Login</button></a>
			</div>
	 
</body>
</html>