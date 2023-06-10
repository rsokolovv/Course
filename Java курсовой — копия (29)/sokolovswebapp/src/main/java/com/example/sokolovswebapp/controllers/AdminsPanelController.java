package com.example.sokolovswebapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminsPanelController {
    private UserRestController userRestController;

    @Autowired
    public AdminsPanelController(UserRestController userRestController){
        this.userRestController = userRestController;
    }

    @GetMapping("/admins-panel")
    public String adminsPanelMain(Model model){
        model.addAttribute("title", "Личный кабинет");
        return "admins-panel";
    }

    @PostMapping("/admins-panel/registration")
    public String registerUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("role") String role){
        userRestController.register(username, password, role);
        return "/home";
    }

    @GetMapping("/admins-panel/registration")
    public String showRegistrationForm(){
        return "registration";
    }
}
