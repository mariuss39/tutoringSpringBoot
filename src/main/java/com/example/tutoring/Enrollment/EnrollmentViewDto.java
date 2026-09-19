package com.example.tutoring.Enrollment;

public record EnrollmentViewDto
        (Long id,
         Long idSubject,
         Long idStudent,
         String nameSubject,
         String nameStudent)
{
    public static EnrollmentViewDto fromEnrollment(Enrollment e){
        return new EnrollmentViewDto(e.getId(),e.getSubject().getId(),e.getStudent().getId(),e.getSubject().getName(),e.getStudent().getName());
    }
}
