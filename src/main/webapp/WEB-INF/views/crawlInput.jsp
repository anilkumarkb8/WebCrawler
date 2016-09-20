<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<body>
	<h2>Web Crawler</h2>


	<form:form method="post" action="crawler">

		<table>
			<tr>
				<td><form:label path="inputUrl">Enter URL to be crawled</form:label></td>
				<td><form:input path="inputUrl" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>

	</form:form>


</body>
</html>