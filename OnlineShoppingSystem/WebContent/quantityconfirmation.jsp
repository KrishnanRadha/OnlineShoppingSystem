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
			<h1>How Many Product You Want?</h1>
			
			<form action="quantcount" method="post">
			
				<p>Enter Quantity</p>
				<input type="text" name="quant" placeholder="Quantity" required>
				
				<input type="submit" name="op" value="Confirm">
			</form>
		</article>
	</section>
</body>
</html>