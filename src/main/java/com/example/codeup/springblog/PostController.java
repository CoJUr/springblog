package com.example.codeup.springblog;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class PostController {
    @GetMapping("/posts")
    public String returnIndex(Model model) {
        List<Post> postsList = new ArrayList<>(Arrays.asList(
                new Post("Selling junk", 1, "This is a post about selling junk"),
                new Post("Buying junk", 2, "This is a post about buying junk"),
                new Post("Will work for food", 3, "This is a post about working for food")
        ));

        model.addAttribute("posts", postsList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnID(@PathVariable long id, Model model) {

        Post post = new Post("My first post", id, "No seriously it is");
        model.addAttribute("id", id);
        model.addAttribute("post", post);

        return "posts/show";
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
