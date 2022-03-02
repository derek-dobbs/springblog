package com.codeup.regulusspringblog.controllers;

import com.codeup.springblog.models.Book;
import com.codeup.springblog.models.Genre;
import com.codeup.springblog.repositories.AuthorRepository;
import com.codeup.springblog.repositories.BookRepository;
import com.codeup.springblog.repositories.GenreRepository;
import com.codeup.springblog.services.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BookController {
    private BookRepository bookDao;
    private AuthorRepository authorsDao;
    private GenreRepository genresDao;
    private final EmailService emailService;

    public BookController(BookRepository bookDao, AuthorRepository authorsDao, GenreRepository genresDao, EmailService emailService) {
        this.bookDao = bookDao;
        this.authorsDao = authorsDao;
        this.genresDao = genresDao;
        this.emailService = emailService;
    }

    @GetMapping("/books")
    public String showBooks(Model model) {
        model.addAttribute("allBooks", bookDao.findAll());
        return "books/index";
    }

    @GetMapping("/books/create")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("genres", genresDao.findAll());
        return "books/create";
    }

    @PostMapping("/books/create")
    public String createBook(@ModelAttribute Book book) {
        book.setAuthor(authorsDao.getById(1L));
        bookDao.save(book);
        return "redirect:/books";
    }

    @GetMapping("/send-email")
    public String sendEmail() {
        emailService.prepareAndSend("Testing", "Did this work");
        return "redirect:/";
    }

}
