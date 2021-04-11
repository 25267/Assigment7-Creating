package org.example.bean;

import java.io.Serializable;

public class PostLikeBean implements Serializable {

    private  Long id = null;
    private Long user_id = null;
    private Long post_id = null;


    public PostLikeBean() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }
}
