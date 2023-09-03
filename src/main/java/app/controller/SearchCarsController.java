package app.controller;


import app.AdditionalClass;
import app.entity.Motorization;
import app.service.MotorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@Controller
public class SearchCarsController {

    @Autowired
    private MotorizationService motorizationService;

    List<Motorization> motorizationList;

    @GetMapping("/searchCars")
    public String formSearchCars(Model model){

        model.addAttribute("additionalClass",new AdditionalClass());

        return "show_with_filter";
    }

    @PostMapping("/searchCars")
    public String searchCarsWithFilter(@ModelAttribute("additionalClass") AdditionalClass additionalClass, Model model){

        motorizationList=motorizationService.getMotorization_with_filter(additionalClass);

        model.addAttribute("listOfMotorization",motorizationList);

        String validator_of_price;

        int price_from=additionalClass.getMotorizationFirst().getPrice();

        int price_to=additionalClass.getMotorizationSecond().getPrice();

        if(price_from>price_to){
            validator_of_price="Podane ceny są nieprawidłowe ponieważ cena od jest wieksza od ceny do.";
        }
        else{
            validator_of_price="";
        }
        int year_from=additionalClass.getMotorizationFirst().getYear();

        int year_to=additionalClass.getMotorizationSecond().getYear();

        String validator_of_year;

        if(year_from>year_to){

            validator_of_year="Podane lata są nieprawidłowe ponieważ rok od jest większy niż rok do.";
        }
        else{
            validator_of_year="";
        }

        model.addAttribute("validator_of_price",validator_of_price);

        model.addAttribute("validator_of_year",validator_of_year);

        return "/show_with_filter";
    }
}
