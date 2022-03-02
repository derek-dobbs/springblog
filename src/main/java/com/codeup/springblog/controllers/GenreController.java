package com.codeup.springblog.controllers;

import com.codeup.springblog.repositories.AuthorRepository;
import com.codeup.springblog.repositories.GenreRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class GenreController {
    private GenreRepository genreDao;

    public GenreController(GenreRepository genreDao) {
        this.genreDao = genreDao;
    }

    @GetMapping("/genres/{id}")
    public String showBooks(@PathVariable long id, Model model) {
        model.addAttribute("books", genreDao.getById(id).getBooks());
        model.addAttribute("chosenGenre", genreDao.getById(id).getName());
        return "genre";
    }
}
