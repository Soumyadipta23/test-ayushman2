package test_ayushman.example.test_ayushman.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test_ayushman.example.test_ayushman.model.Doctor;
import test_ayushman.example.test_ayushman.repository.DoctorRepository;
import test_ayushman.example.test_ayushman.repository.PatientRepository;

import java.util.Map;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

    @Autowired
    private DoctorRepository doctorRepo;
    @Autowired private PatientRepository patientRepo;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> req) {
        String abhaId = req.get("abhaId");
        String abhaPass = req.get("abhaPassword");
        String regId = req.get("registrationId");
        String regPass = req.get("regPassword");

        var patient = patientRepo.findById(abhaId);
        var doctor = doctorRepo.findById(regId);

        if (patient.isEmpty() || !patient.get().getPassword().equals(abhaPass)) {
            return ResponseEntity.status(401).body("Invalid patient");
        }

        if (doctor.isEmpty() || !doctor.get().getPassword().equals(regPass)) {
            return ResponseEntity.status(401).body("Invalid doctor");
        }

        Doctor doc = doctor.get();
        doc.getVerifiedPatients().add(abhaId);
        doctorRepo.save(doc);
        return ResponseEntity.ok("Doctor login successful after verifying patient");
    }
}
