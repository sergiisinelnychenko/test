<%@ include file="include.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<body>
	<c:if test="${not empty prevCalcMsg}">
		<c:out value="${prevCalcMsg}" />
	</c:if>
	<h2>
		<spring:message code="msg.calculatingFor" />
		<c:out value="${shapeName}" />
		:
	</h2>
	<br />
	<form:form method="POST" modelAttribute="data">
		<c:forEach items="${data.fields}" var="fld" varStatus="status">
			<spring:message code="msg.enterValue" />
			<c:out value="${fld.name}" /> : <form:input
				path="fields[${status.index}].value" size="5" />
			<br />
		</c:forEach>
		<br />
		<input type="submit" value="<spring:message code="btn.submit"/>" />
	</form:form>
	<br />
	<a href="${contextName}"><spring:message code="msg.goToIndex" /></a>
</body>
</html>
