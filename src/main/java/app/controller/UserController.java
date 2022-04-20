package app.controller;

import app.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String showUsers(Model model) {
        Iterable<User> users = userService.allUsers();
        model.addAttribute("users", users);
        return "usersPage";
    }

    @GetMapping(value = "/new")
    public String newUser(Model model){
        model.addAttribute("user", new User());
        return "editPage";
    }

    @PostMapping(value = "/edit")
    public String create(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/edit/{id}")
    public String editPage(@PathVariable("id") int id, Model model) throws Exception {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "editPage";
    }

    @GetMapping(value = "/delete/{id}")
    public String remove(@PathVariable("id") int id) throws Exception {
        User user = userService.getById(id);
        userService.delete(user);
        return "redirect:/users";
    }
}

