package com.example.student.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

import com.example.student.Student;

import repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Integer id) {
        return studentRepository.findById(id);
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }

    // --- CÁC HÀM MỚI ---
    
    // Tìm kiếm sinh viên
    public List<Student> searchStudents(String keyword) {
        return studentRepository.findByNameContainingIgnoreCase(keyword);
    }

    // Cập nhật sinh viên
    public Student updateStudent(Integer id, Student newInfo) {
        return studentRepository.findById(id).map(student -> {
            student.setName(newInfo.getName());
            student.setEmail(newInfo.getEmail());
            return studentRepository.save(student);
        }).orElseGet(() -> {
            // Nếu không tìm thấy thì tạo mới luôn (hoặc tùy logic bạn)
            newInfo.setId(id);
            return studentRepository.save(newInfo);
        });
    }
}