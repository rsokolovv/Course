package com.example.sokolovswebapp.controllers;

import com.example.sokolovswebapp.models.News;
import com.example.sokolovswebapp.models.Teachers;
import com.example.sokolovswebapp.repositories.TeachersInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TeachersController {

    @Autowired
    private TeachersInterface teachersInterface;

    @GetMapping("/teachers")
    public String newsMain(Model model) {
        Iterable<Teachers> mteachers = teachersInterface.findAll();
        model.addAttribute("mteachers", mteachers);
        return "teachers";
    }

    @GetMapping("/teachers-add")
    public String newsAdd(Model model){
        return "teachers-add";
    }

    @PostMapping("/teachers-add")
    public String newsPostAdd(@RequestParam String fioteach, @RequestParam String teachbirth, @RequestParam String teachscience, @RequestParam String teachnumb, Model model) {
        Teachers post = new Teachers(fioteach, teachbirth, teachscience, teachnumb);
        teachersInterface.save(post);
        return "redirect:/teachers";
    }

    @GetMapping("/teachers/{id}/edit")
    public String teachersEdit(@PathVariable(value = "id") long id, Model model) {
        if (!teachersInterface.existsById(id)) {
            return "redirect:/teachers";
        }
        Optional<Teachers> post = teachersInterface.findById(id);
        ArrayList<Teachers> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "teachers-edit";
    }

    @PostMapping("/teachers/{id}/edit")
    public String teachersUpdate(@PathVariable(value = "id") long id, @RequestParam String fioteach, @RequestParam String teachbirth, @RequestParam String teachscience, @RequestParam String teachnumb, Model model) {
        Teachers post = teachersInterface.findById(id).orElseThrow();
        post.setFioteach(fioteach);
        post.setTeachbirth(teachbirth);
        post.setTeachscience(teachscience);
        post.setTeachnumb(teachnumb);
        teachersInterface.save(post);
        return "redirect:/teachers";
    }

    @PostMapping("/teachers/{id}/remove")
    public String teachersPostDelete(@PathVariable(value = "id") long id, Model model) {
        Teachers post = teachersInterface.findById(id).orElseThrow();
        teachersInterface.delete(post);
        return "redirect:/teachers";
    }
}

