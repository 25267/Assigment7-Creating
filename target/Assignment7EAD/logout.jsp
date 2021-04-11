<jsp:useBean id="user" class="org.example.bean.UserBean" scope="session"/>
<jsp:setProperty name="user" property="*"/>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    user.userLogout();

    response.sendRedirect("index.jsp");
%>
</body>
</html>
