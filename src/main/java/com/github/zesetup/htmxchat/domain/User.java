package com.github.zesetup.htmxchat.domain;

import java.util.UUID;

public class User {

  private String id;
  private String name;


  public User(String username) {
    this.id = UUID.randomUUID().toString();
    this.name = username;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

}
