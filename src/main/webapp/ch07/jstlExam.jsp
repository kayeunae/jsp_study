<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSTL 종합예제</h2>
	<hr>
	<h3>set, out</h3>
	<!-- pageScope 영역에 저장된다. -->
	<%--var는 변수 선언, value에 값 저장(태그, 문자열, 배열(오류 무시하면 됨) 삽입 가능) --%>
	<c:set var="product1" value="<b>애플 아이폰</b>" />
	<c:set var="product2" value="삼성 갤럭시 노트" />
	<c:set var="intArray" value="${[1,2,3,4,5]}" />
	
	<%-- default: 출력할 문자열이 없을 때 기본적으로 출력되는 내용 설정 --%>
	<p>
	product1:
		<c:out value="${product1}" default="Not registered" escapeXml="true"></c:out>
	</p>
	
	<p>product1(el): ${product1}</p>
	
	<p>intArray[2]: ${intArray[2]}</p>
	<hr>
	
	<h3>foreach배열 출력</h3>
	<ul>
		<!-- items:출력할 배열을 el형식으로 작성.
		varStatus: 상태정보변수(인덱스 번호, 반복횟수 확인 가능) -->
		<!-- for(int num : intArray)와 같음 -->
		<c:forEach var="num" varStatus="i" items="${intArray}">
		<li>${i.index} : ${num}</li>
		</c:forEach>
	</ul>
	<hr>
	
	<h3>if문</h3>
	<c:set var="checkout" value="true" />
	
	<!-- test: jstl에서 쓰이는 키워드. -->
	<!-- if(checkout == true) 과 같음 -->
	<c:if test="${checkout}">
		<p>주문 제품: ${product2}</p>
	</c:if>
	
	<!-- if(checkout != true)과 같음 -->
	<c:if test="${!checkout}">
		<p>주문 제품이 아님</p>
	</c:if>
	
	<!-- product2 에 값이 들어가 있는지 아닌지 체크한다. -->
	<c:if test="${!empty product2}">
		<b>${product2} 이미 있음 !</b>
	</c:if>
	<hr>
	
	<h3>choose, when, otherwise</h3>
	<c:choose>
		<c:when test="${checkout}">
			<p>주문 제품: ${product2}</p>
		</c:when>
		<c:otherwise>
			<p>주문 제품이 아님</p>
		</c:otherwise>
	</c:choose>
	<hr>
	
	<h3>forTokens</h3>
	<!-- delims: 문자열을 구분(파싱)할 기준 문자 -->
	<c:forTokens var="city" items="Seoul/Tokyo/New Yock/Toronto" delims="/" varStatus="i">
		<!-- "${i.first}": 인덱스가 첫 번째면 true를 반환함 -->
		<!-- if(i.first == true)와 같음 -->
		<c:if test="${i.first}"> 도시목록: </c:if>
		${city}
		
		<!-- "${i.last}": 인덱스가 마지막이면 true를 반환함 -->
		
		<!-- if(i.last != true)와 같음 -->
		<!-- 인덱스가 마지막이 아니면 실행. -->
		<c:if test="${!i.last}">, </c:if>
	</c:forTokens>
	 
</body>
</html>