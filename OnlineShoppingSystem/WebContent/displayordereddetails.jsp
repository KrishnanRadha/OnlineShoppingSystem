<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ordered Details</title>
</head>
<body>
	<section>
		<nav>
			<jsp:include page="customeroperation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Ordered Details</h1>
			<c:if test="${op=='ordered_details'}">
				<table id="customers">
					<tr>
						<th>Customer Id</th>
						<th>Product Id</th>
						<th>Price</th>
						<th>Quantity</th>
					</tr>
					
					<c:forEach var="prod" items="${list }">
						
						<tr>
								<td>${prod.getCid()}</td>
								<td>${prod.getPid()}</td>
								<td>${prod.getCost()}</td>
								<td>${prod.getQuant()}</td>
						</tr>
					
					</c:forEach>
					
				</table>
			
			</c:if>
			
			
		</article>
	</section>
</body>
</html>