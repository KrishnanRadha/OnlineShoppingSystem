
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		
			<c:if test="${op=='Admin_Login'}">
				<h1><c:out value="${message}"></c:out></h1>
			</c:if>
		
			<c:if test="${op=='Add_Product'}">
				<h1><c:out value="${message}"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='Add_Customer'}">
				<h1><c:out value="${message}"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='Remove_Product'}">
				<h1><c:out value="${message}"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='Remove_Customer'}">
				<h1><c:out value="${message}"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='Find_Product'}">
				<h1><c:out value="${message}"></c:out></h1>
			</c:if>
			
			
			
			<c:if test="${op=='Display_Products'}">
				<table id="customers">
					<tr>
						<th>Product Id</th>
						<th>Product Name</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Discount</th>
					</tr>
					
					<c:forEach var="prod" items="${list }">
						
						<tr>
							<td><c:out value="${prod.getPid()}"></c:out></td>
							<td><c:out value="${prod.getPname()}"></c:out></td>
							<td><c:out value="${prod.getPrice()}"></c:out></td>
							<td><c:out value="${prod.getQuant()}"></c:out></td>
							<td><c:out value="${prod.getDiscount()}"></c:out></td>
						</tr>
					
					</c:forEach>
					
				</table>
			
			</c:if>
			
			
			
			<c:if test="${op=='orderdetailes'}">
			<h1>Ordered Details</h1>
				<table id="customers">
					<tr>
						<th>Customer Id</th>
						<th>Product Id</th>
						<th>Price</th>
						<th>Quantity</th>
						<th>Delivary Option</th>
					</tr>
					
					<c:forEach var="prod" items="${list }">
						
						<tr>
							<form action="delivered">
								<td><input type="hidden" name="cid" value="${prod.getCid()}">${prod.getCid()}</td>
								<td><input type="hidden" name="pid" value="${prod.getPid()}">${prod.getPid()}</td>
								<td>${prod.getCost()}</td>
								<td>${prod.getQuant()}</td>
								<td><input type="submit" name="op" value="Delivered"></td>
							</form>
						</tr>
					
					</c:forEach>
					
				</table>
			
			</c:if>
			
			<c:if test="${op=='Message'}">
				<h1><c:out value="${message}"></c:out></h1>
			</c:if>
			
			<c:if test="${op=='Display_Customers'}">
				<h1>Customers Details</h1>
				<table id="customers">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Phone No</th>
						<th>Location</th>
						<th>PinCode</th>
						<th>Wallet Amt</th>
					</tr>
					
					<c:forEach var="cust" items="${list }">
						
						<tr>
								<td>${ cust.getCid()}</td>
								<td>${ cust.getCname()}</td>
								<td>${ cust.getPhoneno()}</td>
								<td>${ cust.getLocation()}</td>
								<td>${ cust.getPincode()}</td>
								<td>${ cust.getWallet()}</td>
						</tr>
					
					</c:forEach>
					
				</table>
			
			</c:if>
			
		</article>
	</section>
</body>
</html>