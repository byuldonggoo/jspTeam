<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<h1>메인화면</h1>

<%

	if(session.getAttribute("sessionID")!=null){
	Object sessionid=session.getAttribute("sessionID");
	out.print(sessionid);
%>


<a href="../login/logout.jsp">로그아웃</a>
	<a href="../join/joinForm.jsp">회원가입</a>
	<a href="../join/test.jsp">테스트</a>

<% 	
	}

	else if(session.getAttribute("sessionID")==null){
		
%>
<a href="../login/loginForm.jsp">로그인</a>
	<a href="../join/joinForm.jsp">회원가입</a>
		<a href="../join/test.jsp">테스트</a>
<% 	
	}
%>


<%-- <c:if test="${sessionScope.id!=null}">
	<a href="../login/logout.jsp">로그아웃</a>
	<a href="../join/joinForm.jsp">회원가입</a>
</c:if>

<c:if test="${sessionScope.id==null}">
	<a href="../login/loginForm.jsp">로그인</a>
	<a href="../join/joinForm.jsp">회원가입</a>
</c:if> --%>

</body>
</html>