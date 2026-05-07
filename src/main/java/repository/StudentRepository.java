package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByNameContainingIgnoreCase(String name);
}