package com.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String posts() {
        return "Here are the posts:";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String postsById(@PathVariable String id) {
        return "Here is post #: " + id;
    }

    @GetMapping("/posts/create")
    @ResponseBody
    public String createPostForm() {
        return "Here is post creation form: ";
    }

    @PostMapping("/posts/create")
    @ResponseBody
    public String createNewPost () {
        return "Here is the newly created post:";
    }
}
