<%@ page import="java.time.LocalDateTime"%>
<%@ page import="java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Simple Calcurator</title>
</head>
<body>
<h1>Simple Calcurator</h1>
<p>Input form</p>
<form action="CalculatorServlet" method="post">
    <input type="text" name="num1" value="${param.num1}" placeholder="数値1">
    <input type="text" name="num2" value="${param.num2}" placeholder="数値2">
    <input type="radio" name="operator" value="+">  +
    <input type="radio" name="operator" value="-">  -
    <input type="radio" name="operator" value="*">  ×
    <input type="radio" name="operator" value="/">  ÷
    <br>
    <br>
    <button type="submit">計算</button>
</form>
    <p>結果: <span id ="result">${error}${result}</span></p>

</body>
</html>