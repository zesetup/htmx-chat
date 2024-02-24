package com.github.zesetup.htmxchat.domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Chat {
  private String id;
  private Set<User> users = new HashSet<>();
  private List<Message> messages = new ArrayList<>();
  public Chat() {
    id = UUID.randomUUID().toString();
  }
  public Chat(Set<User> users, List<Message> messages) {
    id = UUID.randomUUID().toString();
    this.users = users;
    this.messages = messages;
  }
  public Set<User> getUsers() {
    return users;
  }

  public void addUser(User user) {
    if(!users.contains(user)) {
      this.users.add(user);
    }
  }

  public List<Message> getMessages() {
    return messages;
  }
  public void setMessages(List<Message> messages) {
    this.messages = messages;
  }

  public void addMessage(Message message) {
    this.messages.add(message);
  }

}
