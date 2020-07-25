<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
			
				<form action="display_products" method="post">
				<button type="submit" name="op" value="display_products">Display Product</button>
				</form>
				
				<form action="displaycartlist" method="post">
				<button type="submit" name="op" value="Display_Cart">Display Product From Cart</button>
				</form>
				
				<form action="ordered_detailes" method="post">
				<button type="submit" name="op" value="ordered_details">Display Ordered details</button>
				</form>
				<a href="addmoneytowallet.jsp"><button>Add Money to Wallet</button></a>
				
				<form action="showbalance">
				<button type="submit" name="op" value="show balance">Show balance from Wallet</button>
				</form>
				<a href="http://localhost:8080/OnlineShoppingSystem/"><button>logout</button></a>
			</div>
		
</body>
</html>