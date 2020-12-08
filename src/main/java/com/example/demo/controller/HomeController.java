package com.example.demo.controller;

import com.example.demo.entity.Message;
import com.example.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class HomeController {
    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("msgs", messageRepository.findAll());
        return "userhome";
    }

    @PostMapping("/messages")
    public String saveMessage(Message message) {
        messageRepository.save(message);
        return "redirect:/home";
    }
}
