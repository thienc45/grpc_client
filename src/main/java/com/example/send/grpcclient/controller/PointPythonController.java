package com.example.send.grpcclient.controller;

import com.example.send.grpcclient.entity.User;
import com.example.send.grpcclient.service.PointServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/points")
public class PointPythonController {
    @Autowired
    private PointServiceClient pointServiceClient;

    @GetMapping("/index")
    public String index(Model model) {
        List<User> users = pointServiceClient.getUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping("/add")
        public String addPoints(@RequestParam String userId, @RequestParam int points) {
        pointServiceClient.addPoints(userId, points);
        return "redirect:/points/index";
    }

    @PostMapping("/subtract")
    public String subtractPoints(@RequestParam String userId, @RequestParam int points) {
        pointServiceClient.subtractPoints(userId, points);
        return "redirect:/points/index";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = pointServiceClient.getUsers();
        model.addAttribute("users", users);
        return "index";
    }
}
