package com.codessquad.qna.controller;

import com.codessquad.qna.domain.User;
import com.codessquad.qna.exception.NotLoginException;
import com.codessquad.qna.repository.UserRepository;
import com.codessquad.qna.service.UserService;
import com.codessquad.qna.utill.HttpSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserRepository userRepository;
    private final UserService userService;

    UserController(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping
    public String createUser(User user) {
        userRepository.save(user);
        return "redirect:/users";
    }

    @GetMapping
    public String showUsers(Model model) {
        model.addAttribute("users",userRepository.findAll());
        return "/user/list";
    }

    @GetMapping("/{userId}")
    public String showUser(@PathVariable String userId, Model model) {
        model.addAttribute("user", userRepository.findByUserId(userId));
        return "user/profile";
    }

    @GetMapping("/{id}/form")
    public String getUpdateForm(@PathVariable Long id, HttpSession session, Model model) {
        model.addAttribute("user", userRepository.findById(id).get());
        return "/user/updateForm";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, String checkPassword, User newUser) {
        User user = userRepository.findById(id).get();

        if(!user.isMatchingPassword(checkPassword)) {
            return "redirect:/";
        }
        userRepository.save(user.update(newUser));

        return "redirect:/users";
    }

    @GetMapping("/login")
    public String getLoginForm() {
        return "/user/login";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        HttpSessionUtils.setSession(userService.login(userId, password), session);
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        HttpSessionUtils.removeSession(session);
        return "redirect:/";
    }




}
