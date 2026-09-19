package com.example.tutoring.Student;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService{
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository sp){this.studentRepository=sp;}

    public List<StudentViewDto> getAll(){
        return studentRepository.findAll().stream().map(StudentViewDto::fromStudent).toList();
    }

    public StudentViewDto addStudent(StudentFormDto sfd){
        Student s1=studentRepository.save(new Student(sfd.name(),sfd.email(),sfd.password()));
        return StudentViewDto.fromStudent(s1);
    }

}
