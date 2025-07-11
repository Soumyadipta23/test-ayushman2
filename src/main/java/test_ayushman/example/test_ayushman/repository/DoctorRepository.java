package test_ayushman.example.test_ayushman.repository;




import test_ayushman.example.test_ayushman.model.Doctor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepository extends MongoRepository<Doctor, String> {}
