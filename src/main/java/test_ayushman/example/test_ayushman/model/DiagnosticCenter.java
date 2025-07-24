package test_ayushman.example.test_ayushman.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "diagnostic_centers")
public class DiagnosticCenter {
    @Id
    private String registrationId;
    private String password;
    private String name;
    private List<String> verifiedPatients = new ArrayList<>();

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getVerifiedPatients() {
        return verifiedPatients;
    }

    public void setVerifiedPatients(List<String> verifiedPatients) {
        this.verifiedPatients = verifiedPatients;
    }
}