<%@ page contentType="text/html;charset=euc-kr"%>

<%
	request.setCharacterEncoding("euc-kr");	// form ���� �Ѿ���� ���� �ѱ��� ��� �ʿ��� ��
%>

<html>
<h1>Request ����1</h1>

<%
	String name = request.getParameter("name");	//����ȯ�� �ʿ���� �޾ƿü� �ִ� getParameter
	String studentNum = request.getParameter("studentNum");
	String gender = request.getParameter("gender");
	String major = request.getParameter("major");

	if(gender.equals("m")){
		gender = "����";
	}else{
		gender = "����";
	}
%>

<body>
���� : <%=name%><p>
�й� : <%=studentNum%><p>
���� : <%=gender%><p>
�а� : <%=major%>
</body>
</html>

