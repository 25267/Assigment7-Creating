
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" class="org.example.bean.UserBean" scope="session"/>
<jsp:setProperty name="user" property="*"/>

<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    if (user.userLogin("jdbc:postgresql://localhost:5432/myForum_db?user=postgres&password=1991"))
        response.sendRedirect("forumPosts.jsp");
    else
        response.sendRedirect("login.html");

%>
</body>
</html>
