<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
			<c:if test="${op=='Display_Cart' }">
	<h1>Cart List</h1>
			<c:forEach var="prod" items="${list}">
				<div style="background-color: silver;padding-top: 10px;">
					<div style="margin-left: 60px; padding-bottom: 20px;">
					
						<form action="cart_order" method="post">
							<h2>
								<input type="hidden" name="pname" value="${prod.getPname() }">${prod.getPname() }
							</h2>
							<h4>
								Product Id : <input type="hidden" name="pid" value="${prod.getPid() }">${prod.getPid() }
							</h4>
							<h4>
								Price : <input type="hidden" name="price" value="${prod.getPrice() }">${prod.getPrice() }
							</h4>
							<h4>
								Quantity : <input type="hidden" name="quant" value="${prod.getQuant() }">${prod.getQuant() }
							</h4>
							<h4>
								Discount : <input type="hidden" name="discount" value="${prod.getDiscount() }"> ${prod.getDiscount()}%
							 </h4>
							 <table>
							 	<tr>
							 		<td><input type=submit name="op" value="Order"></td>
							 	</tr>
							 </table>
						</form>
					</div>
				</div>
			</c:forEach>
		</c:if>	
	</section>
	
	
</body>
</html>