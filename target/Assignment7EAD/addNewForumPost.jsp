<jsp:useBean id="user" class="org.example.bean.UserBean" scope="session"/>
<jsp:useBean id="post" class="org.example.bean.PostBean" scope="page"/>
<jsp:setProperty name="post" property="*"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%

    post.newPost("jdbc:postgresql://localhost:5432/myForum_db?user=postgres&password=1991", user.getId());
    response.sendRedirect("forumPosts.jsp");

%>
</body>
</html>
