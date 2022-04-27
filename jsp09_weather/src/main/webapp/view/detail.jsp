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
	<h2>날씨 상세정보</h2>
	
	<c:forEach var="w" items="${wInfo}">
		<table border="1">	
			<tr>
				<td width="100">목차</td>
				<td>내용</td>
			</tr>
			<tr>
				<td>발표시간</td>
				<td>${w.tmFc}</td>
			</tr>
			<tr>
				<td>장소</td>
				<td> 
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
				</td>
			</tr>

			<tr>
				<td>특보사항</td>
				<td>${w.wn}</td>
			</tr>	
			<tr>
				<td>예비특보</td>
				<td>${w.wr}</td>
			</tr>
		</table>
		<hr> <hr>
		<h3>기상정보</h3> 
		${w.wfSv1}
	</c:forEach>
	
</body>
</html>