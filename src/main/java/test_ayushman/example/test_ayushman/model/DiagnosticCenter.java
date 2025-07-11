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

    public List<String> getVerifiedPatients() {
        return verifiedPatients;
    }

    public void setVerifiedPatients(List<String> verifiedPatients) {
        this.verifiedPatients = verifiedPatients;
    }

    public Object getPassword() {
        return null;
    }

    // Getters and setters
}
