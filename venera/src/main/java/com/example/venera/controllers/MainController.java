package com.example.venera.controllers;

import com.example.venera.services.EventService;
import java.time.Year;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private EventService eventService;

    @Autowired
    public MainController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping(path = {"/", ""})
    public String showIndex(Model model) {
        model.addAttribute("eventsPrevious", eventService.getPreviousEvents());
        model.addAttribute("eventsFuture", eventService.getFutureEvents());
        model.addAttribute("year", eventService.getYear());
        return "index";
    }
}
