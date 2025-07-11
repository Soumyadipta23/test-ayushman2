package test_ayushman.example.test_ayushman.controller;



import test_ayushman.example.test_ayushman.model.Report;
import test_ayushman.example.test_ayushman.repository.ReportRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/upload")
public class UploadController {

    @Autowired
    private ReportRepository reportRepo;

    @PostMapping
    public ResponseEntity<?> upload(@RequestParam("file") MultipartFile file,
                                    @RequestParam String abhaId,
                                    @RequestParam String uploadedBy,
                                    @RequestParam String type) throws IOException {
        String path = "uploads/" + file.getOriginalFilename();
        File dest = new File(path);
        file.transferTo(dest);

        Report r = new Report();
        r.setAbhaId(abhaId);
        r.setUploadedBy(uploadedBy);
        r.setType(type);
        r.setFilePath(path);
        r.setDate(LocalDate.now());

        reportRepo.save(r);
        return ResponseEntity.ok("Report uploaded");
    }
}
