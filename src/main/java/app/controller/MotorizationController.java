package app.controller;


import app.entity.Motorization;
import app.entity.User;
import app.service.MotorizationService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class MotorizationController {

    @Autowired
    private MotorizationService motorizationService;
    @Autowired
    private UserService userService;


    @GetMapping("/addAdvertisementMotorization")
    public String addAdvMotorizationForm(Model model){

        model.addAttribute("motorization",new Motorization());

        return "addMotorization";
    }

    @PostMapping("/addAdvertisementMotorization")
    public String addAdvMotorization(@ModelAttribute("motorization")Motorization motorization){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        String username=authentication.getName();

        User user=userService.getUser(username);

        motorizationService.saveMotorization(motorization,user);

        return "addMotorization";

    }
}
