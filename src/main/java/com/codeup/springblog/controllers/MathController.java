package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MathController {
    @RequestMapping(path = "/add/{num1}/and/{num2}", method = RequestMethod.GET)
    @ResponseBody
    public String addition(@PathVariable int num1, @PathVariable int num2) {
        return "The answer is: " + (num1 + num2);
    }
    // NOTE: If you return an int, you might see some weird html to display it.
    @GetMapping("/subtract/{num1}/from/{num2}")
    @ResponseBody
    public int subtraction(@PathVariable int num1, @PathVariable int num2) {
        return num1 - num2;
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public int multiplication(@PathVariable int num1, @PathVariable int num2) {
        return num1 * num2;
    }

    @GetMapping("/divide/{num1}/by/{num2}")
    @ResponseBody
    public double division(@PathVariable double num1, @PathVariable double num2) {
        return num1 / num2;
    }

}