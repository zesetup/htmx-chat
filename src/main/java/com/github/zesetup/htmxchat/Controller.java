package com.github.zesetup.htmxchat;

import com.github.zesetup.htmxchat.domain.Chat;
import com.github.zesetup.htmxchat.domain.Message;
import com.github.zesetup.htmxchat.domain.User;
import com.github.zesetup.htmxchat.service.ChatService;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@org.springframework.stereotype.Controller
public class Controller {

  @Autowired
  ChatService chatService;


  @GetMapping({"/"})
  public String getIdForm() {
    return "index";
  }

  @PostMapping({"send-message/"})
  public String recieveMessage(@RequestParam(value = "userId", required = true) String userId,
      @RequestParam(value = "messageText", required = true) String messageText, Model model) {
    Chat chat = chatService.getChat();
    User user = chat.getUsers().stream().filter(u -> u.getId().equals(userId)).findFirst().orElse(null);
    Message message = new Message(user, messageText);
    chat.addMessage(message);
    model.addAttribute("messages", chat.getMessages());
    return "messages";
  }

  @PostMapping({"messages/"})
  public String recieveMessages(Model model) {
    Chat chat = chatService.getChat();
    model.addAttribute("messages", chat.getMessages());
    return "messages";
  }


  @GetMapping({"chat-login/"})
  public String hello(@RequestParam(value = "username", required = true) String userName,
      Model model) {
    Chat chat = chatService.getChat();
    User user = chat.getUsers().stream().filter(u -> u.getName().equals(userName)).findFirst()
        .orElse(new User(userName));
    chat.addUser(user);
    model.addAttribute("userId", user.getId());
    model.addAttribute("username", user.getName());
    model.addAttribute("users", new ArrayList<>(chat.getUsers()));
    model.addAttribute("messages", chat.getMessages());
    return "chat";
  }

  @GetMapping({"/validate-username/"})
  public String validateUserId(
      @RequestParam(value = "username", required = false) String userName) {
    if (userName == null || userName.isEmpty()) {
      System.out.println("button-disabled");
      return "button-disabled";
    }
    if (userName.length() >= 2) {
      System.out.println("button-enabled");
      return "button-enabled";
    } else {
      System.out.println("button-disabled");
      return "button-disabled";
    }
  }


}

