package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    //Request Mapping
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String increment(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }

    // Roll Dice from Views Exercise

    @GetMapping("/roll-dice")
    public String showOptions() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String showResult(@PathVariable int n, Model model) {
        int randomNum = (int)(Math.random() * 6) + 1;

//
        model.addAttribute("randomNum", randomNum);
//

        if(n == randomNum) {
            model.addAttribute("result", "You guessed correctly!");
        } else {
            model.addAttribute("result", "Sorry, your guess was incorrect.");
        }
        return "roll-dice";
    }

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }

}//end class HelloController
