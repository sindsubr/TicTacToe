<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<script type="text/javascript">
	function clickAndDisable(link) {
		alert("Entered clickAndDisable function");
		this.href = "''";
	}
</script>
<body>
	<div align="center">
		<h1 style="color: green;">Welcome to Tic Tac Toe game</h1>
		<br> <br>

		<!-- 		<ul> -->
		<%-- 		 <li>${data}</li>  --%>
		<!-- 		 </ul> -->
		<form:form modelAttribute="gameModel">
			<table border="1"
				style="width: 50%; height: 50%; border-color: brown">
				<c:forEach var="boardMap" items="${players.boardMap}"
					varStatus="status">
					<c:if test="${status.index % 3 == 0 }">
						<tr align="center">
					</c:if>

					<td><c:url value="process" var="completeURL">
							<c:param name="tilePos" value="${boardMap.key}" />
							<c:param name="turn" value="${players.turn}"></c:param>
						</c:url> <a href="${completeURL}" style="color: purple; font-size: 40;">${boardMap.value }</a>

						<c:if test="${status.index % 3 == numAppsPerLine-1 }">
							</tr>
						</c:if>
				</c:forEach>
			</table>
		Turn <form:input path="turn" />
		</form:form>

	</div>
</body>
</html>
