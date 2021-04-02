package com.codessquad.qna.controller;

import com.codessquad.qna.domain.User;
import com.codessquad.qna.service.UserService;
import com.codessquad.qna.utill.HttpSessionUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public String createUser(User user) {
        userService.save(user);

        return "redirect:/users";
    }

    @GetMapping
    public String showUsers(Model model, HttpSession session) {
        HttpSessionUtils.loginCheck(session);
        model.addAttribute("users",userService.findAll());

        return "/user/list";
    }

    @GetMapping("/{userId}")
    public String showUser(@PathVariable String userId, Model model) {
        model.addAttribute("user", userService.findByUserId(userId));

        return "user/profile";
    }

    @GetMapping("/{checkId}/form")
    public String getUpdateForm(@PathVariable Long checkId, HttpSession session, Model model) {
        User user = HttpSessionUtils.getLoginUser(session);
        if(!user.isMatchingId(checkId)) {

            return "/user/updateFailed";
        }
        model.addAttribute("user", userService.findById(checkId));

        return "/user/updateForm";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable Long id, String checkPassword, User newUser) {
        User user = userService.findById(id);
        if(!user.isMatchingPassword(checkPassword)) {
            return "redirect:/";
        }
        userService.save(user.update(newUser));

        return "redirect:/users";
    }

    @PostMapping("/login")
    public String login(String userId, String password, HttpSession session) {
        User user = userService.findByUserId(userId);

        if(user == null || !user.isMatchingPassword(password)) {
            return "/user/loginFailed";
        }
        HttpSessionUtils.setSession(user, session);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        HttpSessionUtils.removeSession(session);

        return "redirect:/";
    }

}
