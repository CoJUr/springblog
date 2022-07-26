package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PostController {
    @GetMapping("/posts")
    @ResponseBody
    public String returnIndex() {
        return "Post index page";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String returnID(@PathVariable String id) {
        return "You want to go to post #: " + id;
    }


    @GetMapping("/posts/create")
    @ResponseBody
    public String viewCreationForm() {
        return "Look at how to make a post here: ";
    }


    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost() {
        return "Create a new post here: ";
    }
}
