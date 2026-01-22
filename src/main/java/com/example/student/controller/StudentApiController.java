package com.example.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.example.student.Student;
import com.example.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*") // <--- QUAN TRỌNG: Dòng này giúp web HTML gọi được API
public class StudentApiController {

    @Autowired
    private StudentService studentService;

    // 1. Lấy danh sách
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // 2. Thêm mới
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    // 3. Cập nhật (Dùng POST theo yêu cầu của bạn)
    @PostMapping("/update/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // 4. Xóa (Dùng POST theo yêu cầu của bạn)
    @PostMapping("/delete/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    // 5. Lấy chi tiết
    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    // 6. Tìm kiếm
    @GetMapping("/search")
    public List<Student> searchStudents(@RequestParam String name) {
        return studentService.searchStudents(name);
    }
}