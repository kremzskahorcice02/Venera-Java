package com.example.venera.controllers;

import com.example.venera.models.Admin;
import com.example.venera.models.Event;
import com.example.venera.models.dtos.EventDto;
import com.example.venera.services.AdminService;
import com.example.venera.services.EventService;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Date;

@Controller
public class AdminController {

    private final AdminService adminService;

    private final EventService eventService;

    @Autowired
    public AdminController(AdminService adminService, EventService eventService) {
        this.adminService = adminService;
        this.eventService = eventService;
    }

    @GetMapping(path = "/login")
    public String showLogin(@ModelAttribute Admin admin, Model model) {
        model.addAttribute("admin", admin);
        return "login";
    }

    @PostMapping(path = "/login")
    public String login(@RequestParam("name") String name,
                        @RequestParam("password") String password,
                        RedirectAttributes redirect) {
        Admin admin = adminService.getAdmin(name, password);
        if (admin == null) {
            redirect.addFlashAttribute("error", "Nesprávné jméno nebo heslo");
            return "redirect:/";
        } else {
            return "redirect:/admin/" + admin.getHash();
        }
    }

    @GetMapping(path = "/admin/{hash}")
    public String signAdminIn(@PathVariable("hash") String hash, Model model) {
        if (adminService.validateAdminByHash(hash)) {
            model.addAttribute("hash", hash);
            model.addAttribute("allEvents", eventService.getEvents());
            return "admin";
        } else {
            return "login";
        }
    }

    @GetMapping(path = "/{hash}/event/add")
    public String addEvent(@PathVariable("hash") String hash, Model model) {
        if (adminService.validateAdminByHash(hash)) {
            model.addAttribute("hash", hash);
            return "addevent";
        } else {
            return "login";
        }
    }

    @PostMapping(path = "/{hash}/event/add")
    public String addEvent(@PathVariable("hash") String hash,
                           @RequestParam("title") String title,
                           @RequestParam("date") String date,
                           @RequestParam("city") String city,
                           @RequestParam("place") String place,
                           @RequestParam("otherArtists") String otherArtists,
                           @RequestParam("url") String url) {
        if (adminService.validateAdminByHash(hash)) {
            eventService.addEvent(title, date, city, place, otherArtists, url);
            return "redirect:/admin/" + hash;
        } else {
            return "login";
        }
    }
}
