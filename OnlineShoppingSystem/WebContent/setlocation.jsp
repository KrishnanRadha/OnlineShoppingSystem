<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Set Location</title>
</head>
<body>
	<section>
		<nav>
			<jsp:include page="customeroperation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Set Location</h1>
			
			<form action="set_location" method="post">
			
				<p>Enter Phone No</p>
				<input type="text" name="phoneno" placeholder="Phone No" required>
				
				<p>Enter Location</p>
				<input type="text" name="location" placeholder="Location" required>
				
				<p>Enter Pin Code</p>
				<input type="text" name="pincode" placeholder="pPincode" required>
				
				<input type="submit" name="op" value="Order">
			</form>
		</article>
	</section>
</body>
</html>