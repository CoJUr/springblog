package com.example.codeup.springblog;

import com.example.codeup.springblog.models.User;
import com.example.codeup.springblog.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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

        return "posts/edit";
    }
    @PostMapping("/posts/{id}/edit")
    public String executeEditForm(@ModelAttribute Post post, @PathVariable long id) {

        postDao.save(post);

        return "posts/edit";
    }


    @GetMapping("/posts/create")
    public String viewCreationForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create";
    }


    @PostMapping("/posts/create")
    public String createPost(@ModelAttribute Post post) {

//        Post post = new Post(title, body );
//        load up the post and send it to the DB
//        post.setTitle(title);
//        post.setBody(body);

//        postDao.save(post);
        post.setUser(userDao.findById(1L).get());
//        note: if the id associated already exists, .save will update that post
        postDao.save(post);
        System.out.println(post.toString());
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



}
