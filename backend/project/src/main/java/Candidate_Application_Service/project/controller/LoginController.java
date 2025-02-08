package Candidate_Application_Service.project.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import Candidate_Application_Service.project.models.Users;
import Candidate_Application_Service.project.service.UsersService;

@Controller
public class LoginController {
    private final UsersService usersService;

    @Autowired
    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model, HttpSession session) {
        Users user = usersService.login(username, password);
        session.setAttribute("user", user);
        if (user != null) {
            model.addAttribute("user", user);
            return "redirect:/application";
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }

    /*
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        Users authenticatedUser = usersService.login(user.getUsername(), user.getPassword());

        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");
        }
    }*/
}
