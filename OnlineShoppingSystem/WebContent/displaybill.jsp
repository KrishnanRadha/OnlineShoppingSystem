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
			<h1>Pay Bill for This Product</h1>
				<div style="padding-top: 10px;">
				<div style="background-color: silver;">
					<div style="margin-left: 60px; padding-bottom: 20px;">
						<form action="order" method="post">
							<h2>
								<input type="hidden" name="pname" value="${prod.getPname() }">${prod.getPname() }
							</h2>
							<h4>
								Product Id : <input type="hidden" name="pid" value="${prod.getPid() }">${prod.getPid() }
							</h4>
							<h4>
								Quantity : <input type="hidden" name="quant" value="${prod.getQuant() }">${prod.getQuant() }
							</h4>
								<c:set var="quant" value="${prod.getQuant()}"></c:set>
								<c:set var="nprice" value="${prod.getPrice()}"></c:set>
								<c:set var="ndis" value="${prod.getDiscount()/100}"></c:set>
								<c:set var="dis" value="${nprice*ndis}"></c:set>
								<c:set var="price" value="${nprice-dis}"></c:set>
								<c:set var="price" value="${price*quant}"></c:set>
								
							 <h4>
								Price : <input type="hidden" name="price" value="${price}">${price}
							</h4>
							 <table>
							 	<tr>
							 		<td><input type=submit name="op" value="Pay"></td>
							 	</tr>
							 </table>
						</form>
					</div>
				</div>
				</div>
				
				
			
		</article>
	</section>
</body>
</html>