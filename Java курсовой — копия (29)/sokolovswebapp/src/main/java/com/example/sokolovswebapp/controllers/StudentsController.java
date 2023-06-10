package com.example.sokolovswebapp.controllers;

import com.example.sokolovswebapp.models.Students;
import com.example.sokolovswebapp.models.Teachers;
import com.example.sokolovswebapp.repositories.StudentsInterface;
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
public class StudentsController {

    @Autowired
    private StudentsInterface studentsInterface;

    @GetMapping("/students")
    public String studentsMain(Model model) {
        Iterable<Students> mstudents = studentsInterface.findAll();
        model.addAttribute("mstudents", mstudents);
        return "students";
    }

    @GetMapping("/students-add")
    public String studentsAdd(Model model) {
        return "students-add";
    }

    @GetMapping("/students/{id}/edit")
    public String teachersEdit(@PathVariable(value = "id") long id, Model model) {
        if (!studentsInterface.existsById(id)) {
            return "redirect:/students";
        }
        Optional<Students> post = studentsInterface.findById(id);
        ArrayList<Students> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "students-edit";
    }

    @PostMapping("/students-add")
    public String studentsTaAdd(@RequestParam String stsurname, @RequestParam String stname, @RequestParam String stthirdna, @RequestParam String stdateob, @RequestParam String studclass, @RequestParam String stdocumentnumber, Model model) {
        Students stpost = new Students(stsurname, stname, stthirdna, stdateob, studclass, stdocumentnumber);
        studentsInterface.save(stpost);
        return "redirect:/students";
    }

    @PostMapping("/students/{id}/edit")
    public String studentsUpdate(@PathVariable(value = "id") long id, @RequestParam String stsurname, @RequestParam String stname, @RequestParam String stthirdna, @RequestParam String stdateob, @RequestParam String studclass, @RequestParam String stdocumentnumber, Model model) {
        Students post = studentsInterface.findById(id).orElseThrow();
        post.setStsurname(stsurname);
        post.setStname(stname);
        post.setStthirdna(stthirdna);
        post.setStdateob(stdateob);
        post.setStudclass(studclass);
        post.setStdocumentnumber(stdocumentnumber);
        studentsInterface.save(post);
        return "redirect:/students";
    }

    @PostMapping("/students/{id}/remove")
    public String studentsPostDelete(@PathVariable(value = "id") long id, Model model) {
        Students post = studentsInterface.findById(id).orElseThrow();
        studentsInterface.delete(post);
        return "redirect:/students";
    }
}

