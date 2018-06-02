<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1,  shrink-to-fit=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	function selectEvent(selectObj) {
		if (selectObj == 1)
			location.href = "MessageList.jsp";
		if (selectObj == 2)
			location.href = "MessageList2.jsp";
	}
	
	function fun_img(im) {
		var src = document.getElementById("src");;
		src.file = im;
	}
</script>
</head>
<body>
<%@include file="/WEB-INF/jsp/header.jsp" %>
<%@include file="MessageList.jsp" id="src"%>
<%@include file="/WEB-INF/jsp/footer.jsp" %>
</body>
</html>