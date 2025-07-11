package test_ayushman.example.test_ayushman.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import test_ayushman.example.test_ayushman.model.Hospital;
import test_ayushman.example.test_ayushman.model.HospitalLoginRequest;
import test_ayushman.example.test_ayushman.repository.HospitalRepository;

@RestController
@RequestMapping("/api/hospital-login")
public class HospitalLoginController {

    @Autowired
    private HospitalRepository hospitalRepository;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody HospitalLoginRequest request) {
        Hospital hospital = hospitalRepository.findByRegistrationId(request.getRegistrationId());

        if (hospital != null && hospital.getPassword().equals(request.getPassword())) {
            return ResponseEntity.ok("Hospital login successful.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid registration ID or password.");
        }
    }
}

