//package com.example.send.grpcclient.controller;
//
//import com.example.send.grpcclient.entity.User;
//import com.example.send.grpcclient.service.PointServiceClient;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/points")
//public class PointController {
//
//    @Autowired
//    private PointServiceClient pointServiceClient;
//
//    @PostMapping("/add")
//    public int addPoints(@RequestParam String userId, @RequestParam int points) {
//        return pointServiceClient.addPoints(userId, points);
//    }
//
//    @PostMapping("/subtract")
//    public int subtractPoints(@RequestParam String userId, @RequestParam int points) {
//        return pointServiceClient.subtractPoints(userId, points);
//    }
//
//    @GetMapping("/users")
//    public List<User> getUsers() {
//        return pointServiceClient.getUsers();
//    }
//}
