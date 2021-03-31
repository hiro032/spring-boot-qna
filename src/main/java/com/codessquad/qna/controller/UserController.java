package com.codessquad.qna.controller;

import com.codessquad.qna.domain.User;
import com.codessquad.qna.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
@Controller
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;

    UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public String createUser(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping("")
    public String showUsers(Model model) {
        model.addAttribute("users",userRepository.getUsers());
        return "/user/list";
    }

    @GetMapping("/{userId}")
    public String showUser(@PathVariable String userId, Model model) {
        model.addAttribute("user", userRepository.findByUserId(userId));
        return "user/profile";
    }

}
