package com.example.tutoring.Enrollment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    public EnrollmentController(EnrollmentService enrollmentService){this.enrollmentService=enrollmentService;}

    @GetMapping("/students/{studentId}/enrollments")
    public List<EnrollmentViewDto> findEnrollmentByStudentId(@PathVariable Long studentId){
        return enrollmentService.getByStudentId(studentId);
    }
    @PostMapping("/students/{studentId}/enrollments")
    public ResponseEntity<EnrollmentViewDto> addEnrollment(@PathVariable Long studentId, @RequestParam Long subjectId){
        EnrollmentViewDto saved=enrollmentService.createEnrollment(subjectId,studentId);
        URI location= URI.create("/students/"+saved.idStudent()+"/enrollments/"+saved.id());
        return ResponseEntity.created(location).body(saved);
    }
}
