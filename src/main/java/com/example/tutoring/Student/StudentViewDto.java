package com.example.tutoring.Student;

public record StudentViewDto(Long id, String name, String email){
    public static StudentViewDto fromStudent(Student student){
        return new StudentViewDto(student.getId(),student.getName(),student.getPasswordHash());}
}
