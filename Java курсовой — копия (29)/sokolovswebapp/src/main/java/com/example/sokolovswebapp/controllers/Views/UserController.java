package com.example.sokolovswebapp.controllers.Views;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/upload-file")
    public String uploadPage() {
        return "upload-file";
    }

    @GetMapping("/file")
    public String getFilePage() {
        return "file";
    }
}
