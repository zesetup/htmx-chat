package com.github.zesetup.htmxchat.domain;

import java.time.LocalDateTime;

public class Message {
    private User user;
    private String text;
    private LocalDateTime time;

    public Message(User user, String text) {
        this.user = user;
        this.text = text;
        this.time = LocalDateTime.now();
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public LocalDateTime getTime() {
        return time;
    }
    public void setTime(LocalDateTime time) {
        this.time = time;
    }
    public String getUserName(){
        return user.getName();
    }
}
