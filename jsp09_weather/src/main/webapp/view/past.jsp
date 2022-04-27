<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${path}/weather/search">
		<h2>기록 조회</h2>
		<select name="stnId">
			<option selected ="selected" disabled>선택</option>
			<option value="all">전체</option>
			<option value="108">전국</option>
			<option value="109">수도권</option>
			<option value="159">부산</option>
			<option value="143">대구</option>
			<option value="156">광주</option>
			<option value="146">전주</option>
			<option value="133">대전</option>
			<option value="131">청주</option>
			<option value="105">강원</option>
			<option value="184">제주</option>
		</select>
		<button>조회</button>	
	</form>
	<hr>
	<table border="1">
		<tr>
			<th width="100">지역</th>
			<th width="200">날짜</th>
		</tr>	
		<c:forEach var="w" items="${wlist}">
			<tr>
				<th>
					<c:choose>
						<c:when test="${w.stnId=='108'}">전국</c:when>
						<c:when test="${w.stnId=='109'}">수도권</c:when>
						<c:when test="${w.stnId=='159'}">부산</c:when>
						<c:when test="${w.stnId=='143'}">대구</c:when>
						<c:when test="${w.stnId=='156'}">광주</c:when>
						<c:when test="${w.stnId=='146'}">전주</c:when>
						<c:when test="${w.stnId=='133'}">대전</c:when>
						<c:when test="${w.stnId=='131'}">청주</c:when>
						<c:when test="${w.stnId=='105'}">강원</c:when>
						<c:when test="${w.stnId=='184'}">제주</c:when>
					</c:choose>
				</th>
				<th><a href="${path}/weather/detail?stnId=${w.stnId}&tmFc=${w.tmFc}">${w.tmFc}</a></th>
			</tr>
		</c:forEach>
	</table>		
</body>
</html>