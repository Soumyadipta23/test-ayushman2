package test_ayushman.example.test_ayushman.repository;




import test_ayushman.example.test_ayushman.model.DiagnosticCenter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiagnosticCenterRepository extends MongoRepository<DiagnosticCenter, String> {
    DiagnosticCenter findByRegistrationId(String registrationId);
}
