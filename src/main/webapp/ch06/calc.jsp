<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int n1 = Integer.parseInt(request.getParameter("n1"));
int n2 = Integer.parseInt(request.getParameter("n2"));
System.out.println("n1: " + n1);
System.out.println("n2: " + n2);

//연산자는 문자열 형태로 받아옴
String op = request.getParameter("op");
System.out.println("op: " + op);

//연산의 결과를 담을 변수
long result = 0;

switch(op) {
	case "+" : result = n1 + n2; break;
	case "-" : result = n1 - n2; break;
	case "*" : result = n1 * n2; break;
	case "/" : result = n1 / n2; break;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	결과: <%=result %>
</body>
</html>