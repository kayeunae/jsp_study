<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! String test = "Hello, Java Server Pages"; %>
<%! String getString() {
	return this.test;	
} %>
<%! String getString(String str) {
	return str;	
} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%=getString() %>
	<%=getString(test) %>
</body>
</html>