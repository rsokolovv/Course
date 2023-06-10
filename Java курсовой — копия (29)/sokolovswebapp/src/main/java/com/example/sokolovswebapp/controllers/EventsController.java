package com.example.sokolovswebapp.controllers;

import com.example.sokolovswebapp.models.Events;
import com.example.sokolovswebapp.models.Journals;
import com.example.sokolovswebapp.models.News;
import com.example.sokolovswebapp.repositories.EventsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class EventsController{

    @Autowired
    private EventsInterface eventsInterface;

    @GetMapping("/events")
    public String eventsMain(Model model) {
        Iterable<Events> mevents = eventsInterface.findAll();
        model.addAttribute("mevents", mevents);
        return "events";
    }

    @GetMapping("/events-out")
    public String eventsOutMain(Model model) {
        Iterable<Events> mevents = eventsInterface.findAll();
        model.addAttribute("mevents", mevents);
        return "events-out";
    }

    @GetMapping("/events-add")
    public String eventsAdd(Model model){
        return "events-add";
    }


    @PostMapping("/events-add")
    public String eventsPAdd(@RequestParam String titles, @RequestParam String anonse, @RequestParam String full_texte, @RequestParam String publicatione, Model model) {
        Events post = new Events(titles, anonse, full_texte, publicatione);
        eventsInterface.save(post);
        return "redirect:/events-out";

    }
    @GetMapping("/events-out/{id}/edit")
    public String eventsEdit(@PathVariable(value = "id") long id, Model model) {
        if (!eventsInterface.existsById(id)) {
            return "redirect:/events-out";
        }
        Optional<Events> post = eventsInterface.findById(id);
        ArrayList<Events> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "events-edit";
    }

    @PostMapping("/events-out/{id}/edit")
    public String eventsUpdate(@PathVariable(value = "id") long id, @RequestParam String titles, @RequestParam String anonse, @RequestParam String full_texte, @RequestParam String publicatione, Model model) {
        Events post = eventsInterface.findById(id).orElseThrow();
        post.setTitles(titles);
        post.setAnonse(anonse);
        post.setFull_texte(full_texte);
        post.setPublicatione(publicatione);
        eventsInterface.save(post);
        return "redirect:/events-out";
    }

    @PostMapping("/events-out/{id}/remove")
    public String eventsPostDelete(@PathVariable(value = "id") long id, Model model) {
        Events post = eventsInterface.findById(id).orElseThrow();
        eventsInterface.delete(post);
        return "redirect:/events-out";
    }
}
