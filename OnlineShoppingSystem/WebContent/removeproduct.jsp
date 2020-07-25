<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Remove Product</title>
</head>
<body>
	<section>
		<nav>
			<jsp:include page="adminoperation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Remove Product</h1>
			
			<form action="remove_product" method="post">
				<p>Enter Product Id</p>
				<input type="text" name="pid" placeholder="Id" required>
				
				<input type="submit" name="op" value="Remove_Product">
			</form>
		</article>
	</section>
</body>
</html>