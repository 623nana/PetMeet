<%@ page contentType="text/html; charset=utf-8"  %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type">
<link rel="stylesheet" href="style/petstore.css" type="text/css" />
<title>JPetStore Demo</title>
</head>
<body>
Closing Time이 <c:out value="${closeTime}"/>으로 설정되고 새로운 레코드가 EVENTS 테이블에 저장되었습니다.
<br><br>
spring/spring@orcl로 접속하여 다음 질의를 실행하세요.<br>
<br>
select ID, TO_CHAR(CLOSING_TIME, 'YYYY-MM-DD HH:MI'), STATUS from EVENTS;<br>
<br>
Closing Time이 되면 Scheduler가 지정된 작업을 수행합니다.<br>
(console 창에 메시지를 출력하고, EVENTS 테이블에 있는 레코드의 상태를 'OPEN'에서 'CLOSE'로 변경)<br>
<br>
위 질의를 다시 실행하여 상태 변경 여부를 확인하세요.<br>
<br>
</body>
</html>