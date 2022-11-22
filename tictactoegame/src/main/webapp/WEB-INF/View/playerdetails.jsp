<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TicTacToe Game</title>
</head>
<body>
<div>
<h1 style="color: green;">Welcome to Tic Tac Toe game</h1>
<form:form modelAttribute="players" action="processGame">
<table>
<tr>
<th>
Enter Player Names:<br><br>
</th>
</tr>
<tr>
<td>
Enter Player X: <form:input path="X"/><br><br></td></tr>
<tr>
<td>
Enter Player O: <form:input path="O"/><br><br></td></tr>
</table>
<form:button>Start Game</form:button>
</form:form>
</div>
</body>
</html>