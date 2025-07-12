package test_ayushman.example.test_ayushman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test_ayushman.example.test_ayushman.model.Hospital;
import test_ayushman.example.test_ayushman.repository.HospitalRepository;
import test_ayushman.example.test_ayushman.repository.PatientRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/hospital-one")
public class HospitalController {

    @Autowired
    private HospitalRepository hospitalRepo;
    @Autowired private PatientRepository patientRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        String abhaId = req.get("abhaId");
        String abhaPass = req.get("abhaPassword");
        String regId = req.get("registrationId");
        String regPass = req.get("regPassword");

        var patient = patientRepo.findById(abhaId);
        var hospital = hospitalRepo.findById(regId);

        if (patient.isEmpty() || !patient.get().getPassword().equals(abhaPass)) {
            return ResponseEntity.status(401).body("Invalid patient");
        }

        if (hospital.isEmpty() || !hospital.get().getPassword().equals(regPass)) {
            return ResponseEntity.status(401).body("Invalid hospital");
        }

        Hospital hosp = hospital.get();
        hosp.getVerifiedPatients().add(abhaId);
        hospitalRepo.save(hosp);
        return ResponseEntity.ok("Hospital login successful after verifying patient");
    }
}
