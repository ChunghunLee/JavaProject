<%@ page contentType="text/html;charset=euc-kr"%>

<%
	request.setCharacterEncoding("euc-kr");	// form 에서 넘어오는 값이 한글인 경우 필요한 문
%>

<html>
<h1>Request 예제1</h1>

<%
	String name = request.getParameter("name");	//형변환이 필요없이 받아올수 있는 getParameter
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");

	if(gender.equals("m")){
		gender = "남자";
	}else{
		gender = "여자";
	}
%>

<body>
성명 : <%=name%><p>
학번 : <%=studentNum%><p>
성별 : <%=gender%><p>
학과 : <%=major%>
</body>
</html>

