package com.example.sokolovswebapp.controllers;

import com.example.sokolovswebapp.models.Journals;
import com.example.sokolovswebapp.repositories.JournalsInterface;
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
public class JournalsController {

    @Autowired
    private JournalsInterface journalsInterface;

    @GetMapping("/journals")
    public String journalsMain(Model model) {
        Iterable<Journals> mjournals = journalsInterface.findAll();
        model.addAttribute("mjournals", mjournals);
        return "journals";
    }

    @GetMapping("/journals-out")
    public String journalsOutMain(Model model) {
        Iterable<Journals> mjournals = journalsInterface.findAll();
        model.addAttribute("mjournals", mjournals);
        return "journals-out";
    }

    @GetMapping("/journals-add")
    public String journalsAdd(Model model) {
        return "journals-add";
    }


    @PostMapping("/journals-add")
    public String journalsStAdd(@RequestParam String rstudclass, @RequestParam String rfiost, @RequestParam String rmath, @RequestParam String rruslang, @RequestParam String rgeom, @RequestParam String rphysic, @RequestParam String rchem, @RequestParam String rtrain, Model model) {
        Journals post = new Journals(rstudclass, rfiost, rmath, rruslang, rgeom, rphysic, rchem, rtrain);
        journalsInterface.save(post);
        return "redirect:/journals-out";
    }

    @GetMapping("/journals-out/{id}/edit")
    public String journalsEdit(@PathVariable(value = "id") long id, Model model) {
        if (!journalsInterface.existsById(id)) {
        return "redirect:/journals-out";
        }
        Optional<Journals> post = journalsInterface.findById(id);
        ArrayList<Journals> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "journals-edit";
    }

    @PostMapping("/journals-out/{id}/edit")
    public String journalsStUpdate(@PathVariable(value = "id") long id, @RequestParam String rstudclass, @RequestParam String rfiost, @RequestParam String rmath, @RequestParam String rruslang, @RequestParam String rgeom, @RequestParam String rphysic, @RequestParam String rchem, @RequestParam String rtrain, Model model) {
        Journals post = journalsInterface.findById(id).orElseThrow();
        post.setRstudclass(rstudclass);
        post.setRfiost(rfiost);
        post.setRmath(rmath);
        post.setRruslang(rruslang);
        post.setRgeom(rgeom);
        post.setRphysic(rphysic);
        post.setRchem(rchem);
        post.setRtrain(rtrain);
        journalsInterface.save(post);
        return "redirect:/journals-out";
    }

    @PostMapping("/journals-out/{id}/remove")
    public String journalsPosDelete(@PathVariable(value = "id") long id, Model model) {
        Journals post = journalsInterface.findById(id).orElseThrow();
       journalsInterface.delete(post);
        return "redirect:/journals-out";
    }

}