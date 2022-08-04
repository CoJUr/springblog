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

        postsList = postDao.findAll();
        model.addAttribute("posts", postsList);
        return "posts/index";
    }

    @GetMapping("/posts/{id}")
    public String returnID(@PathVariable long id, Model vModel) {

        Post post = postDao.findById(id).get();
        vModel.addAttribute("post", post);
        return "posts/show";
    }


//    editing post functionality
    @GetMapping("/posts/{id}/edit")
    public String sendEditForm(@PathVariable long id, Model model) {

        Post post = postDao.findById(id).get();
        model.addAttribute("id", id);
        model.addAttribute("post", post);

        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String executeEditForm(@ModelAttribute Post post) {

        Post postToUpdate = postDao.findById(post.getId()).get();
        postToUpdate.setTitle(post.getTitle()); //update title of post
        postToUpdate.setBody(post.getBody()); //update body of post

        postDao.save(postToUpdate);
        return "redirect:/posts";
    }


//    post creating functionality
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

        emailService.prepareAndSend(newPost, "New Post created");
        return "redirect:/posts";
    }


//    post read/view functionality
    @GetMapping("/posts/read/{id}")
    public String readPost(@PathVariable long id, Model model) throws NoSuchElementException {
        try{
            Optional<Post> post = postDao.findById(id);
            if (post.isPresent()) model.addAttribute("post", post);
            else throw new NoSuchElementException();
        } catch (NoSuchElementException e) {

            return "redirect:/posts";
        }
        return "posts/show";
    }

//    deletion functionality
    @PostMapping("/posts/{id}/delete")
    public String deletePost(@PathVariable long id) {
        postDao.deleteById(id);
        return "redirect:/posts";
    }


}
