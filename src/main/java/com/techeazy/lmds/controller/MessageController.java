package com.techeazy.lmds.controller;


import com.techeazy.lmds.entity.Message;
import com.techeazy.lmds.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
    @RequestMapping("/api/messages")
    public class MessageController {
        @Autowired
        private MessageService messageService;

        @GetMapping
        public List<Message> getAllMessages() {
            return messageService.getAllMessages();
        }

        @GetMapping("/{id}")
        public Message getMessageById(@PathVariable Long id) {
            return messageService.getMessageById(id);
        }

        @PostMapping
        public Message createMessage(@RequestBody Message message) {
            return messageService.saveMessage(message);
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
            messageService.deleteMessage(id);
            return ResponseEntity.ok().build();
        }
    }

