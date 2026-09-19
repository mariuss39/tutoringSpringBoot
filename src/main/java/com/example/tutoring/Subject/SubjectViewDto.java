package com.example.tutoring.Subject;

public record SubjectViewDto (
        Long id,
        String name,
        String description,
        String teacherName,
        Long teacherId) {
    public static SubjectViewDto fromSubject(Subject subject){
        return new SubjectViewDto(subject.getId(),subject.getName(), subject.getDescription(), subject.getTeacher().getName(),subject.getTeacher().getId());
    }
}
