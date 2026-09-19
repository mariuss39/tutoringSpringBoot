package com.example.tutoring.Student;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService{
    private final StudentRepository studentRepository;
    public StudentService(StudentRepository sp){this.studentRepository=sp;}

    @Transactional(readOnly = true)
    public List<StudentViewDto> getAll(){
        return studentRepository.findAll().stream().map(StudentViewDto::fromStudent).toList();
    }
    @Transactional
    public StudentViewDto addStudent(StudentFormDto sfd){
        Student s1=studentRepository.save(new Student(sfd.name(),sfd.email(),sfd.password()));
        return StudentViewDto.fromStudent(s1);
    }
    @Transactional (readOnly = true)
    public StudentViewDto getById(Long id){
        return studentRepository.findById(id).map(StudentViewDto::fromStudent).orElseThrow();
    }
    @Transactional
    public StudentViewDto updateStudent(StudentFormDto sfd, Long id){
       Student s= studentRepository.findById(id).orElseThrow();
       s.setEmail(sfd.email());
       s.setName(sfd.name());
       return StudentViewDto.fromStudent(s);
    }
}
