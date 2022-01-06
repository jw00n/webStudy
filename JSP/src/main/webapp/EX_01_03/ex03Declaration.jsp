<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%!// <%! : 선언문
	//  전역변수를 선언하거나
	//  메서드를 선언할때 사용

	int num = 100; //class의 멤버 변수
	
	//주로 메서드 선언용
	public void print(int n) {
		System.out.print(n);
	}
	
	public int sum(int n1, int n2){
		int result=n1+n2;
		return result;
	}
	%>

	<%
		print(num);
	out.print(sum(1,3));

	%>
</body>
</html>