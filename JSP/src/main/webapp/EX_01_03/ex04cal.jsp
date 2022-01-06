<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!
		
	public int[] caculator(int n1, int n2){
		int[] result=new int[4];
		result[0]=n1+n2;
		result[1]=n1-n2;
		result[2]=n1*n2;
		result[3]=n1/n2;
		return result;
	}
	
	
	public String sum(int n1, int n2){
		int result=n1+n2;
		
		return n1+"+"+n2+"="+result;
	}
	%>
	<%
	int n1=Integer.parseInt(request.getParameter("num1"));
	int n2=Integer.parseInt(request.getParameter("num2"));
	int[] result=caculator(n1, n2);
	
	%>
	
	<p><%=n1%>+<%=n2%>=<%=result[0]%> </p>
	<p><%=n1%>-<%=n2%>=<%=result[1]%> </p>
	<p><%=n1%>*<%=n2%>=<%=result[2]%> </p>
	<p><%=n1%>/<%=n2%>=<%=result[3]%> </p>
	
</body>
</html>