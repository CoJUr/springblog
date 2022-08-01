package com.example.codeup.springblog;

import com.example.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

@Controller
public class PostController {

    PostRepository postDao;

    private UserRepository userDao;

    public PostController(PostRepository postDao, UserRepository userDao) {
        this.postDao = postDao;
        this.userDao = userDao;

    }

    @GetMapping("/posts")
    public String returnIndex(Model model) {
        List<Post> postsList = new ArrayList<>();

//                new ArrayList<>(Arrays.asList(
//                new Post("Selling junk", 1, "This is a post about selling junk"),
//                new Post("Buying junk", 2, "This is a post about buying junk"),
//                new Post("Will work for food", 3, "This is a post about working for food")
//        ));

        postsList = postDao.findAll();
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
    public String viewCreationForm() {
        return "posts/create";
    }


    @PostMapping("/posts/create/test")
    public String createPost(@RequestParam String title, @RequestParam String body, Model model) {

        Post post = new Post(title, body);
//        if the id associated already exists, .save will update that post
        postDao.save(post);
        System.out.println(post.toString());
        return "redirect:/posts";
    }

//    post read functionality
    @GetMapping("/posts/read/{id}")
    public String readPost(@PathVariable long id, Model model) throws NoSuchElementException {
        try{
            Post post = postDao.findById(id).get();
            model.addAttribute("post", post);

        } catch (NoSuchElementException e) {
//            throw new NoSuchElementException("No post found with id: " + id);
//            alert('No post found with id: ' + id);
            return "redirect:/posts";
        }
        return "posts/show";
    }



}
