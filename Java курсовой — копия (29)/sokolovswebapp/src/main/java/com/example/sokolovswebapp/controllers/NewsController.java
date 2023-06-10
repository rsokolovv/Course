package com.example.sokolovswebapp.controllers;

import com.example.sokolovswebapp.repositories.NewsInterface;
import com.example.sokolovswebapp.models.News;
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
    public class NewsController {

    @Autowired
    private NewsInterface newsInterface;

    @GetMapping("/news")
    public String newsMain(Model model) {
        Iterable<News> mnews = newsInterface.findAll();
        model.addAttribute("mnews", mnews);
        return "news-main";
    }

    @GetMapping("/news-out")
    public String newsOutMain(Model model) {
        Iterable<News> mnews = newsInterface.findAll();
        model.addAttribute("mnews", mnews);
        return "news-out";
    }

    @GetMapping("/news-add")
    public String newsAdd(Model model) {
        return "news-add";
    }


    @PostMapping("/news-add")
    public String newsPostAdd(@RequestParam String title, @RequestParam String anons, @RequestParam String full_text, @RequestParam String publication, Model model) {
        News post = new News(title, anons, full_text, publication);
        newsInterface.save(post);
        return "redirect:/news";
    }

    @GetMapping("/news/{id}")
    public String newsDetails(@PathVariable(value = "id") long id, Model model) {
        if (!newsInterface.existsById(id)) {
            return "redirect:/news";
        }
        Optional<News> post = newsInterface.findById(id);
        ArrayList<News> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "news-details";
    }


    @GetMapping("/news-out/{id}/edit")
    public String newsEdit(@PathVariable(value = "id") long id, Model model) {
        if (!newsInterface.existsById(id)) {
            return "redirect:/news-out";
        }
        Optional<News> post = newsInterface.findById(id);
        ArrayList<News> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "news-edit";
    }

    @PostMapping("/news-out/{id}/edit")
    public String newsUpdate(@PathVariable(value = "id") long id, @RequestParam String title, @RequestParam String anons, @RequestParam String full_text, @RequestParam String publication, Model model) {
        News post = newsInterface.findById(id).orElseThrow();
        post.setTitle(title);
        post.setAnons(anons);
        post.setFull_text(full_text);
        post.setPublication(publication);
        newsInterface.save(post);
        return "redirect:/news-out";
    }

    @PostMapping("/news-out/{id}/remove")
    public String newsPostDelete(@PathVariable(value = "id") long id, Model model) {
        News post = newsInterface.findById(id).orElseThrow();
        newsInterface.delete(post);
        return "redirect:/news-out";
    }
}