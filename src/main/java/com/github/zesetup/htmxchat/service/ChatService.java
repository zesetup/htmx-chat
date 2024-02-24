package com.github.zesetup.htmxchat.service;

import com.github.zesetup.htmxchat.domain.Chat;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

  Chat chat;

  public ChatService() {
    chat = new Chat();
  }

  public Chat getChat() {
    return chat;
  }

}
