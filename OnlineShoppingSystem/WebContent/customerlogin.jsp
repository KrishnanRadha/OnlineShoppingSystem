<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	input[type=text], input[type=password] {
	  width: 100%;
	  padding: 12px 20px;
	  margin: 8px 0;
	  display: inline-block;
	  border: 1px solid #ccc;
	  box-sizing: border-box;
	}
	
	h1{
		text-align:center;
		color:white;
		background-color: green;
	}
	p{
		color: blue;
		font-family:verdana;
		font-size: 20px;
	}
	input[type=Submit] {
	 
	  background-color:green;
	  color: white;
	  padding: 22px 16px;
	  width: 100%;
	  border: none;
	  text-align: left;
	  cursor: pointer;
	  font-size: 17px;
	}
</style>
<body bgcolor="cyan">
	<form action="custpmerslogin" method="post">
		<article>
		 		<div class="custpmerslogin">
					<h1>Customer Login Page</h1>
					<p>Name</p>
					<input type="text" name="name" placeholder="Name" required>
					<p>Password</p>
					<input type="password" name="password" placeholder="Password" required>
					 <input type="submit" name="op" value="Customer_Login">
				</div>
		</article>
	</form>
</body>
</html>