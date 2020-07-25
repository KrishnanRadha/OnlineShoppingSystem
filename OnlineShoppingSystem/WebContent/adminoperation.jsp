<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin operation</title>
</head>
<style>
/*form design*/
input[type=text], input[type=password] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  box-sizing: border-box;
}

h1{
	text-align:center;
	color:white;
	background-color: green;
}
p{
	color: blue;
	font-family:verdana;
	font-size: 20px;
}
input[type=Submit] {
 
  background-color:green;
  color: white;
  padding: 22px 16px;
  width: 100%;
  border: none;
  text-align: center;
  cursor: pointer;
  font-size: 17px;
}

/*layout design*/
header {
  background-color: #666;
  padding: 30px;
  text-align: center;
  font-size: 35px;
  color: white;
}

nav {
  float: left;
  width: 40%;
  height: 100%; 
  background: #ff80ff;
}

article {
  float: right;
  padding: 20px;
  width: 60%;
  background-color: #f1f1f1;
  height: 100%; 
}

section:after {
  content: "";
  display: table;
  clear: both;
}

/*menu design*/

* {box-sizing: border-box}
	body {font-family: "Lato", sans-serif;}

.tab {
  float:none;
  border: 1px solid #ccc;
  background-color: #f1f1f1;
  width: 100%;
  height: 100%;
}

.tab button {
  display: block;
  background-color: inherit;
  color: black;
  padding: 22px 16px;
  width: 100%;
  border: none;
  outline: none;
  text-align: left;
  cursor: pointer;
  font-size: 17px;
}

.tab button:hover {
  background-color: #ddd;
}

.tab button.active {
  background-color: #ccc;
}

a:link {
  text-decoration: none;
}

/*table design*/

#customers {
  font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

#customers td, #customers th {
  border: 1px solid #ddd;
  padding: 8px;
}

#customers tr:nth-child(even){background-color: #f2f2f2;}

#customers tr:hover {background-color: #ddd;}

#customers th {
  padding-top: 12px;
  padding-bottom: 12px;
  text-align: left;
  background-color: #4CAF50;
  color: white;
}
</style>
<body bgcolor="cyan">
		
			<div class="tab">
				<a href="add_product.jsp"><button>Add Product to product List </button></a>
				<a href="removeproduct.jsp"><button>Remove Product</button></a>
				<a href="addcustomer.jsp"><button>Add Customer </button></a>
				<a href="removecustomer.jsp"><button>Remove Customer</button></a>
				
				<form action="display_products">
				<button type="submit" name="op" value="Display_Products">Display products</button>
				</form>
				
				<form action="display_customers">
				<button type="submit" name="op" value="Display_Customers">Display Customers</button>
				</form>
				
				<a href="adminGetOrderedDetails.jsp"><button>Get Ordered details by Customer Id</button></a>
				
				<form action="orderdetailes" method="post">
				<button type="submit" name="op" value="OrderDetailes">Get All Ordered Details</button>
				</form>
				
				<a href="http://localhost:8080/OnlineShoppingSystem/"><button>logout</button></a>
			</div>
		
</body>
</html>