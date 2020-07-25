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
			<jsp:include page="adminoperation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Get Ordered Details</h1>
			
			<form action="orderedrdetailesid" method="post">
			
				<p>Enter Customer Id</p>
				<input type="text" name="cid" placeholder="Id" required>
				
				<input type="submit" name="op" value="Get_Detailes">
			</form>
		</article>
	</section>
</body>
</html>