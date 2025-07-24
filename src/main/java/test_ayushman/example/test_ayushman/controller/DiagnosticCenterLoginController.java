package test_ayushman.example.test_ayushman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test_ayushman.example.test_ayushman.model.DiagnosticCenter;
import test_ayushman.example.test_ayushman.model.DiagnosticCenterLoginRequest;
import test_ayushman.example.test_ayushman.repository.DiagnosticCenterRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/diagnostic")
public class DiagnosticCenterLoginController {

    @Autowired
    private DiagnosticCenterRepository diagnosticCenterRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody DiagnosticCenterLoginRequest request) {
        DiagnosticCenter center = diagnosticCenterRepository.findByRegistrationId(request.getRegistrationId());

        if (center != null) {
            if (center.getPassword().equals(request.getPassword())) {
                return ResponseEntity.ok("Diagnostic center login successful.");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid registration ID or password.");
            }
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Diagnostic center not found.");
        }
    }
}
