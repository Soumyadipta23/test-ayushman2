package test_ayushman.example.test_ayushman.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "patients")
public class Patient {
    @Id
    private String abhaId;
    private String password;
    private String aadhaarNumber;

    public Object getPassword() {
        return null;
    }

    // Getters and setters
}

