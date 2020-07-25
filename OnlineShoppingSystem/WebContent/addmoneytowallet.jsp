<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<section>
		<nav>
			<jsp:include page="customeroperation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Add Money to Wallet</h1>
			
			<form action="add_money" method="post">
			
				<p>Enter Money</p>
				<input type="text" name="price" placeholder="Money" required>
				
				<input type="submit" name="op" value="Add_Money">
			</form>
		</article>
	</section>
</body>
</html>