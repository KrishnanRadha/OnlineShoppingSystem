<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor="cyan">
	<section>
		<nav>
			<jsp:include page="adminoperation.jsp"></jsp:include>
		</nav>
		<article>
			<h1>Add Product to Product List</h1>
			
			<form action="add_product" method="post">
				<p>Enter Product Id</p>
				<input type="text" name="pid" placeholder="Id" required>
				
				<p>Enter Product Name</p>
				<input type="text" name="pname" placeholder="Name" required>
				
				<p>Enter Product Price</p>
				<input type="text" name="price" placeholder="Price" required>
				
				<p>Enter Quantity</p>
				<input type="text" name="quant" placeholder="Quantity" required>
				
				<p>Enter Discount</p>
				<input type="text" name="discount" placeholder="discount" required>
				
				<input type="submit" name="op" value="Add_Product">
			</form>
		</article>
	</section>
</body>
</html>