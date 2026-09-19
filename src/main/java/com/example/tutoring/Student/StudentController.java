package com.example.tutoring.Student;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController{

    private final StudentService studentService;

    public StudentController(StudentService ss){this.studentService=ss;}

    @GetMapping
    public List<StudentViewDto> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public StudentViewDto getById(@PathVariable Long id){
        return studentService.getById(id);
    }
    @PostMapping
    public ResponseEntity<StudentViewDto> addStudent(@RequestBody StudentFormDto sfd){
        StudentViewDto created=studentService.addStudent(sfd);
        URI location=URI.create("/students/"+created.id());
        return ResponseEntity.created(location).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentViewDto> updateStudent(@RequestBody StudentFormDto dfd, @PathVariable Long id){
        StudentViewDto updated= studentService.updateStudent(dfd,id);
        return ResponseEntity.ok(updated);
    }
}

