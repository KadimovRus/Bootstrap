package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.services.CustomUserDetailsService;
import ru.kata.spring.boot_security.demo.services.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class MainController {

    final private CustomUserDetailsService customUserDetailsService;
    private final UserServiceImpl userService;

    @Autowired
    public MainController(CustomUserDetailsService customUserDetailsService, UserServiceImpl userService) {
        this.customUserDetailsService = customUserDetailsService;
        this.userService = userService;
    }

    @GetMapping
    public String homePage(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long userId = user.getId();
        user = userService.getUserById(userId);
        model.addAttribute("user", user);
        return "user";
    }

}
