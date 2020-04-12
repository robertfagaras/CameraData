package com.robertfagaras.lpc.services;

import com.robertfagaras.lpc.model.LP;
import com.robertfagaras.lpc.repositories.LpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingService {
    @Autowired
    LpRepo licensePlates;
    public List<LP> getAllParkingInformation() {
       return licensePlates.getLPs();
    }
}
