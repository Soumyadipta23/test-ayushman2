package test_ayushman.example.test_ayushman.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "reports")
public class Report {
    @Id
    private String id;
    private String abhaId;
    private String uploadedBy;
    private String type;
    private String filePath;
    private LocalDate date;

    public void setAbhaId(String abhaId) {
    }

    public void setUploadedBy(String uploadedBy) {
    }

    public void setType(String type) {
    }

    public void setFilePath(String path) {
    }

    public void setDate(LocalDate now) {
    }

    // Getters and setters
}
