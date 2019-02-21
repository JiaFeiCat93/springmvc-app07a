<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Product Form</title>
<style type="text/css">@import url("<c:url value="css/main.css"/>");</style>
</head>
<body>

	<div id="global">
		<p>
			<label>Product Name: </label>
			<span>${product.name}</span>		
		</p>
		<p>
			<label>Product Description: </label>
			<span>${product.description}</span>
		</p>
		<p>
			<label>Product Price: </label>
			<span>${product.price}</span>
		</p>
		<p>
			<label>Product ProductionDate: </label>
			<span>${product.productionDate}</span>
		</p>
	</div>

</body>
</html>