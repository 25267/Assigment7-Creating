package org.example.bean;

import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostBean implements Serializable {

    private Long id = null;
    private String text = null;
    private String subtext = null;
    private Long user_id = null;

    public PostBean() {
    }


    public List<PostBean> findPosts(String dbUrl) throws ClassNotFoundException, SQLException {

        List<PostBean> postBeanList = new ArrayList<>();

        Connection connection = null;

        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(dbUrl);


        PreparedStatement preparedStatement = null;

        preparedStatement = connection.prepareStatement("SELECT * FROM forumposts ");

        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            PostBean postBean = new PostBean();

            postBean.setId(resultSet.getLong("id"));

            postBean.setText(resultSet.getString("text"));

            postBean.setSubtext(resultSet.getString("subtext"));

            postBean.setUser_id(resultSet.getLong("user_id"));

            postBeanList.add(postBean);
        }
//        System.out.println(discussionBeans);

        return postBeanList;

    }

    public int returnPostLikes(String dbUrl, Long post_id) throws ClassNotFoundException, SQLException {

        List<PostLikeBean> postLikeBeanList = new ArrayList<>();

        Connection connection = null;

        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(dbUrl);


        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM postLikes  WHERE post_id=?");

        preparedStatement.setLong(1, post_id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {

            PostLikeBean postLikeBean = new PostLikeBean();

            postLikeBean.setId(resultSet.getLong("id"));
            postLikeBean.setPost_id(resultSet.getLong("post_id"));
            postLikeBean.setUser_id(resultSet.getLong("user_id"));

            postLikeBeanList.add(postLikeBean);

        }

        return postLikeBeanList.size();
    }

    public void TakeBackMyLike(String dbUrl, Long post_id, Long user_id) throws SQLException, ClassNotFoundException {

        Connection connection = null;

        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(dbUrl);

        PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM postLikes WHERE user_id = ? and post_id = ? ");

        preparedStatement.setLong(1, user_id);
        preparedStatement.setLong(2, post_id);

        preparedStatement.executeUpdate();

    }


    public void addMyLike(String url, Long post_id, Long user_id) throws SQLException, ClassNotFoundException {

        Connection connection = null;

        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(url);


        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO postlikes(user_id, post_id) VALUES (?,?)");
        preparedStatement.setLong(1, user_id);
        preparedStatement.setLong(2, post_id);
        preparedStatement.executeUpdate();


    }

    public void  newPost(String url, Long user_id) throws SQLException, ClassNotFoundException {

        Connection connection = null;
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(url);

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO forumposts(text, subtext, user_id) VALUES(?, ?, ?)");

        preparedStatement.setString(1, text);
        preparedStatement.setString(2, subtext);
        preparedStatement.setLong(3, user_id);

        preparedStatement.executeUpdate();
    }


    public boolean returnMyLikes(String dbUrl, Long post_id, Long user_id) throws SQLException, ClassNotFoundException {
        boolean myLike = false;
        List<PostLikeBean> postLikeBeans = new ArrayList<>();

        Connection connection = null;

        Class.forName("org.postgresql.Driver");

        connection = DriverManager.getConnection(dbUrl);

        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM postLikes WHERE user_id = ? and post_id = ?  ");

        preparedStatement.setLong(1, user_id);
        preparedStatement.setLong(2, post_id);

        ResultSet resultSet = preparedStatement.executeQuery();


        while (resultSet.next()) {

            PostLikeBean likeBean = new PostLikeBean();
            likeBean.setId(resultSet.getLong("id"));
            likeBean.setUser_id(resultSet.getLong("user_id"));
            likeBean.setPost_id(resultSet.getLong("post_id"));

            postLikeBeans.add(likeBean);

        }

        if (postLikeBeans.isEmpty())
            myLike = true;
        else {
            myLike = false;
        }

        return myLike;

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSubtext() {
        return subtext;
    }

    public void setSubtext(String subtext) {
        this.subtext = subtext;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
