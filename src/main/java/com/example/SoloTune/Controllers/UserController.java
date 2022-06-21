package com.example.SoloTune.Controllers;

import com.example.SoloTune.models.Role;
import com.example.SoloTune.models.User;
import com.example.SoloTune.repository.ItemRepository;
import com.example.SoloTune.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/user")
    public String user(){
        return "user";
    }

    @GetMapping("/reg")
    public String reg(@RequestParam(name ="error",defaultValue = "",required = false) String error, Model model){
        if(error.equals("email")){
            model.addAttribute("error", "Email уже занят");
        }
        return "reg";
    }

    @PostMapping("/reg")
    public String addUser(@RequestParam String username,
                          @RequestParam String email,
                          @RequestParam String password) {
        if(userRepository.findByEmail(email) != null){
            return "redirect:/reg?error=email";

        }

        password = passwordEncoder.encode(password);
        User user = new User(username,password,email,true, Collections.singleton(Role.USER));
        userRepository.save(user);
        return "redirect:/login";

    }
}
