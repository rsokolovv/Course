package com.example.sokolovswebapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UsersPanelController {

    @GetMapping("/users-panel")
    public String usersPanelMain(Model model) {
        model.addAttribute("title", "Личный кабинет");
        return "users-panel";
    }

    @GetMapping("/users-panel/sciences")
    public String sciences(Model model) {
        model.addAttribute("title", "Мои Дисциплины");
        return "sciences";

    }

    @GetMapping("/users-panel/sciences/russian-language")
    public String russianLanguage(Model model) {
        model.addAttribute("title", "Русский язык и культура речи");
        return "russian-language";

    }

    @GetMapping("/users-panel/sciences/mathematics")
    public String mathematics(Model model) {
        model.addAttribute("title", "Математика(Алгебра)");
        return "mathematics";

    }

    @GetMapping("/users-panel/sciences/geometry")
    public String geometry(Model model) {
        model.addAttribute("title", "Геометрия");
        return "geometry";

    }


    @GetMapping("/users-panel/sciences/physic")
    public String physic(Model model) {
        model.addAttribute("title", "Физика");
        return "physic";
    }

    @GetMapping("/users-panel/sciences/chemistry")
    public String chemistry(Model model) {
        model.addAttribute("title", "Химия");
        return "chemistry";
    }

    @GetMapping("/users-panel/sciences/physical-training")
    public String physicalTraining(Model model) {
        model.addAttribute("title", "Физичекая культура");
        return "physical-training";
    }

}




