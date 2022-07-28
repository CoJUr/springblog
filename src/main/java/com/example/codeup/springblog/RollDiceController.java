package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RollDiceController {

    @GetMapping("/roll-dice")
    public String rollDice() {
        return "roll-dice";


    }

    @GetMapping("/roll-dice/{die}")
    public String rollDice(@PathVariable int die, Model model) {

//        int min = 1;
//        int max = 6;
        int roll = (int) (Math.random() * 6) + 1;
//        double a = Math.random()*(max-min+1)+min;

        model.addAttribute("die", die);
        model.addAttribute("roll", roll);
        return "roll-dice-result";
    }


}
