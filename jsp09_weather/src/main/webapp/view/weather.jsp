<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
	<h2>현재 날씨</h2>
	<form action="${path}/weather/view">
		<select name="stnId">
			<option selected ="selected" disabled>선택</option>
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
		<button type="button" onclick="location.href='${path}/view/past.jsp'">과거 조회기록</button>
	</form>
	<hr>
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