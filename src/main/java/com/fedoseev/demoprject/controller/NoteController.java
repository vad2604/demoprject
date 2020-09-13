package com.fedoseev.demoprject.controller;


import com.fedoseev.demoprject.model.Note;
import com.fedoseev.demoprject.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.RedirectView;
import org.thymeleaf.spring5.view.AbstractThymeleafView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;

@Controller
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("/")
    public String home(Model model) {
        return "redirect:/note_keeper";
    }

    @GetMapping("/note_keeper")
    public String noteHome(Model model) {
        model.addAttribute("note", new Note());

        return "index";
    }

    @PostMapping(value = "/addNote")
    public String action(@ModelAttribute("note") @Valid Note note, BindingResult bindingResult)
    {
         if (bindingResult.hasErrors()) {
             return "index";
         }
         noteService.addNote(note);
         return "redirect:/note_keeper";
    }

}
