<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
</head>
<body>
	<section>
		<nav>
			<jsp:include page="adminoperation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Add Customer</h1>
			
			<form action="add_customer" method="post">
			
				<p>Enter Customer Id</p>
				<input type="text" name="cid" placeholder="Id" required>
				
				<p>Enter Customer Name</p>
				<input type="text" name="cname" placeholder="Name" required>
				
				<p>Enter Customer Password</p>
				<input type="password" name="password" placeholder="Password" required>
				
				<p>Enter Phone No</p>
				<input type="text" name="phoneno" placeholder="Phone No" required>
				
				<p>Enter Location</p>
				<input type="text" name="location" placeholder="Location" required>
				
				<p>Enter Pin Code</p>
				<input type="text" name="pincode" placeholder="Pincode" required>
				
				<p>Enter Amount to Wallet</p>
				<input type="text" name="wallet" placeholder="Amount" required>
				
				<input type="submit" name="op" value="Add_Customer">
			</form>
		</article>
	</section>
</body>
</html>