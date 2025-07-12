package test_ayushman.example.test_ayushman.repository;



import org.springframework.stereotype.Repository;
import test_ayushman.example.test_ayushman.model.Patient;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PatientRepository extends MongoRepository<Patient, String> {}

