package test_ayushman.example.test_ayushman.repository;



import test_ayushman.example.test_ayushman.model.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String> {}
