package test_ayushman.example.test_ayushman.repository;

import org.springframework.stereotype.Repository;
import test_ayushman.example.test_ayushman.model.Hospital;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface HospitalRepository extends MongoRepository<Hospital, String> {
    Hospital findByRegistrationId(String registrationId);
}
