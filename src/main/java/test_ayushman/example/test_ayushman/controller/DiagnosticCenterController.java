package test_ayushman.example.test_ayushman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test_ayushman.example.test_ayushman.model.DiagnosticCenter;
import test_ayushman.example.test_ayushman.repository.DiagnosticCenterRepository;
import test_ayushman.example.test_ayushman.repository.PatientRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/diagnostic-one")
public class DiagnosticCenterController {

    @Autowired
    private DiagnosticCenterRepository repo;
    @Autowired private PatientRepository patientRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        String abhaId = req.get("abhaId");
        String abhaPass = req.get("abhaPassword");
        String regId = req.get("registrationId");
        String regPass = req.get("regPassword");

        var patient = patientRepo.findById(abhaId);
        var center = repo.findById(regId);

        if (patient.isEmpty() || !patient.get().getPassword().equals(abhaPass)) {
            return ResponseEntity.status(401).body("Invalid patient");
        }

        if (center.isEmpty() || !center.get().getPassword().equals(regPass)) {
            return ResponseEntity.status(401).body("Invalid diagnostic center");
        }

        DiagnosticCenter dgn = center.get();
        dgn.getVerifiedPatients().add(abhaId);
        repo.save(dgn);
        return ResponseEntity.ok("Diagnostic center login successful after verifying patient");
    }
}
