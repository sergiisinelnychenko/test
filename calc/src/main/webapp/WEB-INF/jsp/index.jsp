<%@ include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<h2>
		<spring:message code="msg.chooseShape" />
	</h2>
	<br />
	<a href="square.ca"><spring:message code="msg.square.name" /></a>&nbsp;<spring:message code="msg.calculatedNumber" arguments="${storage['msg.square.name']}"/><c:out value="${storage['msg.square.name']}" default="0"/>
	<br />
	<a href="circle.ca"><spring:message code="msg.circle.name" /></a>&nbsp;<spring:message code="msg.calculatedNumber" arguments="${storage['msg.circle.name']}"/><c:out value="${storage['msg.circle.name']}" default="0"/>
	<br />
	<a href="ellipse.ca"><spring:message code="msg.ellipse.name" /></a>&nbsp;<spring:message code="msg.calculatedNumber" arguments="${storage['msg.ellipse.name']}"/><c:out value="${storage['msg.ellipse.name']}" default="0"/>
	<br />
	<a href="triangle.ca"><spring:message code="msg.triangle.name" /></a>&nbsp;<spring:message code="msg.calculatedNumber" arguments="${storage['msg.triangle.name']}"/><c:out value="${storage['msg.triangle.name']}" default="0"/>
	<br />
	<a href="rectangle.ca"><spring:message code="msg.rectangle.name" /></a>&nbsp;<spring:message code="msg.calculatedNumber" arguments="${storage['msg.rectangle.name']}"/><c:out value="${storage['msg.rectangle.name']}" default="0"/>
	<br />
</body>
</html>
