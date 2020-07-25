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
			<h1>Choose Option</h1>
			<form action="orederbyregister">
			<button type="submit" name="op" value="orderbyregister">Use Registered Location</button>
			</form>
			
			<a href="setlocation.jsp"><button>Use Another Location</button></a>
			
		</article>
	</section>
</body>
</html>