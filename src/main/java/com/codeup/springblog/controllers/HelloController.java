package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    // Use curly braces to establish Path Variables in the mapping definition.
    @GetMapping("/hello/{name}")
    @ResponseBody
    // Use annotation to get the value of the Path Variable.
    public String hello(@PathVariable String name) {
        return "Hello, " + name + " !";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test() {
        return "test";
    }

    // REQUEST MAPPING
//    @GetMapping("/increment/{number}")
    @RequestMapping(path = "/increment/{number}", method = RequestMethod.GET)
    @ResponseBody
    public String increment(@PathVariable int number) {
        return number + " plus one is " + (number + 1) + "!";
    }




    // Example of Receiving and Sending Data

    @GetMapping("/join")
    public String showJoinForm() {
        return "join";
    }

    @PostMapping("/join")
    public String joinCohort(@RequestParam(name = "cohort") String cohort, Model model) {
        model.addAttribute("cohort", "Welcome to " + cohort + "!");
        return "join";
    }



    // Passing a collection of data
    @GetMapping("/greek-gods")
    public String showGreekGods(Model model) {
        String[] names = {"Zeus", "Hercules", "Hades", "Apollo"};
        model.addAttribute("greekGods", names);
        return "greekGods";
    }

    // Roll Dice from Views Exercise

    @GetMapping("/roll-dice")
    public String showOptions() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String showResult(@PathVariable int n, Model model) {
        int randomNum = (int)(Math.random() * 6) + 1;
        if(n == randomNum) {
            model.addAttribute("result", "You guessed correctly!");
        } else {
            model.addAttribute("result", "Sorry, your guess was incorrect.");
        }
        return "roll-dice";
    }


}