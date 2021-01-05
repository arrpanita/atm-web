package th.ac.ku.atm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class HomeController {


    public String getHomePage(Model model) {
        model.addAttribute("greeting", "Sawaddee");
        // return home.html
        return "home";
    }
    }

