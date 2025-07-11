package test_ayushman.example.test_ayushman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test_ayushman.example.test_ayushman.repository.PatientRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/patient")
public class PatientController {

    @Autowired
    private PatientRepository repo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> request) {
        String abhaId = request.get("abhaId");
        String password = request.get("password");

        return repo.findById(abhaId)
                .filter(p -> p.getPassword().equals(password))
                .map(p -> ResponseEntity.ok("Patient login successful"))
                .orElse(ResponseEntity.status(401).body("Invalid credentials"));
    }
}
