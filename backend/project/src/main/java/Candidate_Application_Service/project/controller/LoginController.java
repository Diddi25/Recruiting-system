package Candidate_Application_Service.project.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import Candidate_Application_Service.project.models.Users;
import Candidate_Application_Service.project.service.UsersService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
public class LoginController {
    private final UsersService usersService;

    @Autowired
    public LoginController(UsersService usersService) {
        this.usersService = usersService;
    }

    /*@GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }*/

    @PostMapping("/login")
    public ResponseEntity<LoginResult> login(@RequestBody LoginData data, Model model, HttpSession session) {
        String username = data.username;
        String password = data.password;
        Users user = usersService.login(username, password);
        session.setAttribute("user", user);
        if (user != null) {
            model.addAttribute("user", user);
            return new ResponseEntity<>(new LoginResult(true), HttpStatus.OK);
        } else {
            model.addAttribute("error", "Invalid username or password");
            return new ResponseEntity<>(new LoginResult(false), HttpStatus.UNAUTHORIZED);
        }
    }

    public static class LoginData {
        private String username;
        private String password;

        public String getPassword() {
            return password;
        }

        public String getUsername() {
            return username;
        }
    }

    public static class LoginResult {
        LoginResult(boolean success) {
            this.success = success;
        }
        private boolean success;
        public boolean getSuccess() {
            return success;
        }
    }
}
