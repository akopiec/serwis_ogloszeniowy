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
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    public UserService userService;
    @Autowired
    public MotorizationService motorizationService;

    @GetMapping("/userAccount")
    public String getUserAccount(Model model){

        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();

        String username=authentication.getName();

        User user=userService.getUser(username);

        List<Motorization> motorizationList=userService.getUserAccount(user);

        model.addAttribute("listMotorization",motorizationList);

        return "userAccount";

    }
    @GetMapping("/userAccountToUpdate")
    public String updateUserAccountForm(@RequestParam("MotorizationId")Long id, Model model){

        Motorization motorization=motorizationService.getMotorization(id);

        model.addAttribute("motorization",motorization);

        return "addMotorization";

    }
    @PostMapping("/userAccountToUpdate")
    public String updateUserAccount(@RequestParam("MotorizationId")Long id, @ModelAttribute("motorization")Motorization motorizationModel){

        Motorization motorization=motorizationService.getMotorization(id);

        motorizationService.updateMotorization(motorizationModel,id);

        return "redirect:/userAccount";
    }
}
