package com.example.student.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.student.service.StudentService;

import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Trang chủ hiển thị danh sách (nếu bạn có file index.html hoặc students.html)
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students"; // Tên file HTML trong thư mục templates
    }
}