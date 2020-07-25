<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Customer</title>
</head>
<body>
	<section>
		<nav>
			<jsp:include page="adminoperation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Remove Customer</h1>
			
			<form action="remove_customer" method="post">
			
				<p>Enter Customer Id</p>
				<input type="text" name="cid" placeholder="Id" required>
				
				<input type="submit" name="op" value="Remove_Customer">
			</form>
		</article>
	</section>

</body>
</html>