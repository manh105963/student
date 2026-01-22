package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.student.Student;
import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    // Thêm hàm tìm kiếm theo tên (gần đúng, không phân biệt hoa thường)
    List<Student> findByNameContainingIgnoreCase(String name);
}