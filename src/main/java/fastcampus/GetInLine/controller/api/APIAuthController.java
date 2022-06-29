package fastcampus.GetInLine.controller.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIAuthController {

    @GetMapping("/sign-up")
    public String signUp() {
        return "Sign Up Complete";
    }

    @GetMapping("/login")
    public String login() {
        return "Login Complete";
    }

}
