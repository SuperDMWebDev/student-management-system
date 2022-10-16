package com.example.studentmanagementsystem.controller;

import com.example.studentmanagementsystem.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService)
    {
        super();
        this.studentService=studentService;
    }
    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to RestTemplate Example.";
    }
    //handle list student and return model and view
    @GetMapping("/students")
    public String listStudents(Model model)
    {
        System.out.println("get students");
        model.addAttribute("students",studentService.getAllStudents());
        return "students";
    }

}

