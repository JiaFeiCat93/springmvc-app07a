<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product Form</title>
<style type="text/css">@import url("<c:url value="css/main.css"/>");</style>
</head>
<body>
	
	<div id="global">
		<form:form modelAttribute="product" action="product_save" method="post">
		<%-- <form:form modelAttribute="product" action="product_save2" method="post"> --%>
			<fieldset>
				<legend>Add a product</legend>
				<p>
					<form:errors path="name"/>
				</p>
				<p>
					<label for="name">Product Name: </label>
					<form:input id="name" path="name"/>
				</p>
				<p>
					<form:errors path="description"/>
				</p>
				<p>
					<label for="description">Product Description: </label>
					<form:input id="description" path="description"/>
				</p>
				<p>
					<form:errors path="price"/>
				</p>
				<p>
					<label>Product Price: </label>
					<form:input id="price" path="price"/>
				</p>
				<p>
					<form:errors path="productionDate"/>
				</p>
				<p>
					<label for="productionDate">Product ProductionDate: </label>
					<form:input id="productionDate" path="productionDate"/>
				</p>
				<p>
					<input id="reset" type="reset"/>
					<input id="submit" type="submit" value="Add Product"/>
				</p>
			</fieldset>
		</form:form>
	</div>
	
</body>
</html>