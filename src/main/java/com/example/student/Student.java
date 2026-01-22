package com.example.student;

import jakarta.persistence.*; // Dùng jakarta cho Spring Boot 3
// Nếu báo lỗi jakarta thì đổi thành: import javax.persistence.*;

@Entity // BẮT BUỘC: Đánh dấu đây là bảng dữ liệu
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Tự động tăng ID
    private Integer id;

    private String name;
    private String email;

    // --- BẮT BUỘC: Constructor mặc định (rỗng) ---
    public Student() {
    }

    // Constructor có tham số (để dễ tạo mới)
    public Student(String name, String email) {
        this.name = name;
        this.email = email;
    }

    // --- BẮT BUỘC: Getters và Setters ---
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}