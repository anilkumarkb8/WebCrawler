<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web Crawler</title>
<%@ page isELIgnored="false"%>
</head>
<body>
	<h2>Crawling Status , ${status}.</h2>

	<c:if test="${status == 'Success'}">
		<b>Below are the Result of crawling performed on supplied input
			URL</b>
		<br />

		<c:forEach items="${pagesVisited}" var="entry">
			<c:out value="${entry}" />
			<br />
		</c:forEach>
	</c:if>


</body>
</html>