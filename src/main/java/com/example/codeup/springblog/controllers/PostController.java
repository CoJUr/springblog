package com.example.codeup.springblog.controllers;

import com.example.codeup.springblog.model.Post;
import com.example.codeup.springblog.model.User;
import com.example.codeup.springblog.repositories.PostRepository;
import com.example.codeup.springblog.repositories.UserRepository;
import com.example.codeup.springblog.services.EmailService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class PostController {

    PostRepository postDao;

    private UserRepository userDao;

    private final EmailService emailService;

    public PostController(PostRepository postDao, UserRepository userDao, EmailService emailService) {
        this.postDao = postDao;
        this.userDao = userDao;
        this.emailService = emailService;
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

        Post post = postDao.findById(id).get();
        model.addAttribute("id", id);
        model.addAttribute("post", post);

        System.out.println(postDao.findById(3L).get());
        return "posts/show";
    }


//    editing post functionality
    @GetMapping("/posts/{id}/edit")
    public String sendEditForm(@PathVariable long id, Model model) {

        Post post = postDao.findById(id).get();
        model.addAttribute("id", id);
        model.addAttribute("post", post);

        return "redirect:/posts/{id}";
    }
    @PostMapping("/posts/{id}/edit")
    public String executeEditForm(@ModelAttribute Post post, @PathVariable long id) {

        User user = userDao.findById(1L).get();
        post.setUser(user);
        postDao.save(post);

        return "posts/edit";
    }



    @GetMapping("/posts/create")
    public String viewCreationForm(Model model) {
        model.addAttribute("newPost", new Post());
        return "posts/create";
    }



    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post newPost) {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        newPost.setUser(principal);
        postDao.save(newPost);
        System.out.println(newPost.toString());
        emailService.prepareAndSend(newPost, "New Post created");
        return "redirect:/posts";
    }

//    post read functionality
    @GetMapping("/posts/read/{id}")
    public String readPost(@PathVariable long id, Model model) throws NoSuchElementException {
        try{
            Optional<Post> post = postDao.findById(id);
            if (post.isPresent()) model.addAttribute("post", post);
            else throw new NoSuchElementException();
        } catch (NoSuchElementException e) {

//            throw new NoSuchElementException("No post found with id: " + id);
//            alert('No post found with id: ' + id);
            return "redirect:/posts";
        }
        return "posts/show";
    }

    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }


}
