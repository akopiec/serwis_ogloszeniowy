package app.controller;


import app.entity.Authority;
import app.entity.User;
import app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {

    @Autowired
    private  UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Bean
    public PasswordEncoder getPasswordEncoder(){

        return new BCryptPasswordEncoder();
    }

    @GetMapping(value = {"/register"})
    public String registerForm(Model model){

        model.addAttribute("user",new User());

        return "register";
    }
    @PostMapping("/register")
    public String saveUser(@ModelAttribute("user") User user, Model model){

        String validator = validate(user);

        user.setPassword(getPasswordEncoder().encode(user.getPassword()));

        if (!validator.isEmpty()) {

            model.addAttribute("validator", validator);

            return "register";

        } else {
        user.getAuthorities().add(new Authority(user, "ROLE_USER"));

        userService.saveUser(user);

        Authority authority=user.getAuthorities().get(user.getAuthorities().size()-1);

        authorityService.saveAuthority(authority);

        return "redirect:/login";}


    }
    private String validate(User user) {

        if (userService.getUser(user.getUsername()) != null) {

            return "użytkownik o takiej nazwie istnieje";

        } else if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {

            return "wypełnij wszystkie pola";
        }
        return "";
    }

}
