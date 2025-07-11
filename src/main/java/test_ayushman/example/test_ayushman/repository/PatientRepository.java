package test_ayushman.example.test_ayushman.repository;



import test_ayushman.example.test_ayushman.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<Patient, String> {}

