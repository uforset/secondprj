<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
<c:import url="/WEB-INF/views/common/menubar.jsp" />
<hr>

<h2 align="center">${ sessionScope.bill.bill_timestamp }날짜 지출 내역 상세보기</h2>

<table align="center" width="500" border="1" cellspacing="0" cellpadding="5">

	<tr><th>번 호</th><td>${ bill.id }</td></tr>
	<tr><th>내 용</th><td>${ bill.bill_content }</td></tr>
	<tr><th>총 액</th><td>${ bill.bill_price }</td></tr>

	<tr><th colspan="2">
		<button onclick="javascript:history.go(-1);">목록</button>
	</th><td></td></tr>
</table>
<br>
<hr>

<c:import url="/WEB-INF/views/common/footer.jsp" />
</body>
</html>