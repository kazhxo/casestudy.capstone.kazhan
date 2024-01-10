package com.sofy.casestudy.capstone.kazhan.controller;

import com.sofy.casestudy.capstone.kazhan.dto.UserDTO;
import com.sofy.casestudy.capstone.kazhan.entity.Post;
import com.sofy.casestudy.capstone.kazhan.entity.User;
import com.sofy.casestudy.capstone.kazhan.service.PostService;
import com.sofy.casestudy.capstone.kazhan.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@Controller
public class MainController {

    private final UserService userService;
    private final PostService postService;
    private final SimpMessagingTemplate messagingTemplate;


    @Autowired
    public MainController(UserService userService, PostService postService, SimpMessagingTemplate messagingTemplate) {
        this.userService = userService;
        this.postService = postService;
        this.messagingTemplate = messagingTemplate;

    }

    @GetMapping("/profile")
    public String userProfile(Model model, Principal principal) {
        // Get the authenticated user
        User user = userService.findByUsername(principal.getName());

        // Get posts for the user
        List<Post> posts = postService.getPostsByUser(user);

        model.addAttribute("user", user);
        model.addAttribute("posts", posts);

        return "profile";
    }






    @PostMapping("/home/post")
    public String createPost(@RequestParam String content, Principal principal, Model model) {
        // Creating a new post and save it
        User user = userService.findByUsername(principal.getName());
        Post post = new Post();
        post.setContent(content);
        post.setUser(user);
        postService.savePost(post);

        // Broadcast the new post to all users
        messagingTemplate.convertAndSend("/topic/public", "New post added by " + user.getUsername());

        // Get all posts for the main page
        List<Post> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);

        // Return the "main" html
        return "main";
    }




    @PostMapping("/home/post-and-redirect")
    public String createPostAndRedirect(@RequestParam String content, Principal principal) {
        // Processing the post and redirecting to the main page
        return "redirect:/main";
    }

    @GetMapping("/main")
    public String mainPage(Model model, Principal principal) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            // User is authenticated
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            System.out.println("Authenticated user: " + userDetails.getUsername());

            // Get all posts for the main page
            List<Post> posts = postService.getAllPosts();
            model.addAttribute("posts", posts);

            return "main";
        } else {
            // User is not authenticated,
            return "redirect:/login"; // Redirect to login page
        }
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }





    // handle the login form submission here
    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {



            return "/main";

    }

    @GetMapping("/home")
    public String home(Model model, Principal principal) {
        if (principal != null) {
            UserDetails userDetails = (UserDetails) ((Authentication) principal).getPrincipal();
            System.out.println("Authorities: " + userDetails.getAuthorities());

            // Get the authenticated user
            User user = userService.findByUsername(principal.getName());

            model.addAttribute("user", user);
        }

        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("user", userDTO);
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDTO userDTO, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", userDTO);
            return "register";
        }

        // Check if the user is already taken
        if (userService.findByUsername(userDTO.getUsername()) != null) {
            result.rejectValue("username", "error.user", "username is already taken");
            return "register";
        }

        // Convert UserDTO to User entity and save the user
        userService.saveUser(userDTO);

        return "redirect:/registration-success";
    }


}