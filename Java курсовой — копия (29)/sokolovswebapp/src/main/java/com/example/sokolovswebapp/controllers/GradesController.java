package com.example.sokolovswebapp.controllers;

import com.example.sokolovswebapp.models.Events;
import com.example.sokolovswebapp.models.Grades;
import com.example.sokolovswebapp.models.Journals;
import com.example.sokolovswebapp.repositories.GradesInterface;
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
public class GradesController {

    @Autowired
    private GradesInterface gradesInterface;

    @GetMapping("/grades")
    public String gradesMain(Model model) {
        Iterable<Grades> mgrades = gradesInterface.findAll();
        model.addAttribute("mgrades", mgrades);
        return "grades";
    }

    @GetMapping("/grades-out")
    public String gradesOutMain(Model model) {
        Iterable<Grades> mgrades = gradesInterface.findAll();
        model.addAttribute("mgrades", mgrades);
        return "grades-out";
    }

    @GetMapping("/grades-add")
    public String gradesAdd(Model model){
        return "grades-add";
    }


    @PostMapping("/grades-add")
    public String gradesPAdd(@RequestParam String gfiost, @RequestParam String gstudclass, @RequestParam String gtitle, @RequestParam String grate, Model model) {
        Grades post = new Grades(gfiost, gstudclass, gtitle, grate);
        gradesInterface.save(post);
        return "redirect:/grades-out";

    }

    @GetMapping("/grades-out/{id}/edit")
    public String gradesEdit(@PathVariable(value = "id") long id, Model model) {
        if (!gradesInterface.existsById(id)) {
            return "redirect:/grades-out";
        }
        Optional<Grades> post = gradesInterface.findById(id);
        ArrayList<Grades> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "grades-edit";
    }

    @PostMapping("/grades-out/{id}/edit")
    public String gradesUpdate(@PathVariable(value = "id") long id, @RequestParam String gfiost, @RequestParam String gstudclass, @RequestParam String gtitle, @RequestParam String grate, Model model) {
        Grades post = gradesInterface.findById(id).orElseThrow();
        post.setGstudclass(gstudclass);
        post.setGfiost(gfiost);
        post.setGtitle(gtitle);
        post.setGrate(grate);
        gradesInterface.save(post);
        return "redirect:/grades-out";
    }

    @PostMapping("/grades-out/{id}/remove")
    public String gradesPostDelete(@PathVariable(value = "id") long id, Model model) {
        Grades post = gradesInterface.findById(id).orElseThrow();
        gradesInterface.delete(post);
        return "redirect:/grades-out";
    }
}


