package com.robertfagaras.lpc.controller;

import com.robertfagaras.lpc.model.LP;
import com.robertfagaras.lpc.model.Parking;
import com.robertfagaras.lpc.model.User;
import com.robertfagaras.lpc.services.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
public class WelcomeController {

    @Autowired
    ParkingService parkingService;

    @GetMapping("/")
    public String welcome(){
        return "welcome.html";
    }

    @GetMapping("/login")
    public User hello(){
        return new User();
    }


    @GetMapping("/getParking")
    public List<LP> getParking(){
        return parkingService.getAllParkingInformation();
    }
}

