package com.example.tutoring.Enrollment;

import com.example.tutoring.security.CurrentUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class EnrollmentController {
    private final EnrollmentService enrollmentService;
    public EnrollmentController(EnrollmentService enrollmentService){this.enrollmentService=enrollmentService;}

    @GetMapping("/students/{studentId}/enrollments")
    public List<EnrollmentViewDto> findEnrollmentByStudentId(@AuthenticationPrincipal CurrentUser currentUser){
        return enrollmentService.getByStudentId(currentUser.id());
    }
    @PostMapping("/enrollments")
    public ResponseEntity<EnrollmentViewDto> addEnrollment(@AuthenticationPrincipal CurrentUser currentUser, @RequestParam Long subjectId){
        EnrollmentViewDto saved=enrollmentService.createEnrollment(subjectId, currentUser.id());
        URI location= URI.create("/students/"+saved.idStudent()+"/enrollments/"+saved.id());
        return ResponseEntity.created(location).body(saved);
    }
}
