<jsp:useBean id="user" class="org.example.bean.UserBean" scope="session"/>

<jsp:useBean id="like" class="org.example.bean.PostLikeBean" scope="page"/>

<jsp:useBean id="ForumPost" class="org.example.bean.PostBean" scope="page"/>

<jsp:setProperty name="like" property="*"/>


<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    System.out.println("returnMy Lie");
    ForumPost.TakeBackMyLike("jdbc:postgresql://localhost:5432/myForum_db?user=postgres&password=1991", like.getPost_id(),  like.getUser_id() );
    response.sendRedirect("forumPosts.jsp");

%>
</body>
</html>
