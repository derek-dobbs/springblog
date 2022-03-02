package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AuthorController {
    private AuthorRepository authorDao;

    public AuthorController(AuthorRepository authorDao) {
        this.authorDao = authorDao;
    }

    @GetMapping("/authors/{id}")
    public String showBooks(@PathVariable long id, Model model) {
        model.addAttribute("author", authorDao.getById(id));
        return "author";
    }
}
