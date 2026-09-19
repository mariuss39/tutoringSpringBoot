package com.example.tutoring.Teacher;

public record TeacherViewDto(Long id, String name, String email, String description){
    public static TeacherViewDto fromTeacher(Teacher teacher){
        return new TeacherViewDto(teacher.getId(),teacher.getName(),teacher.getEmail(),teacher.getDescription());
    }
}
