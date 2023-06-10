package com.example.sokolovswebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ModeratorsPanelController {
    @GetMapping("/moderators-panel")
    public String moderatorsPanelMain(Model model){
        model.addAttribute("title", "Личный кабинет");
        return "moderators-panel";
    }
}
