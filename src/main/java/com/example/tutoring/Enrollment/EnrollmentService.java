package com.example.tutoring.Enrollment;

import com.example.tutoring.Student.StudentRepository;
import com.example.tutoring.Subject.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EnrollmentService {
    private final EnrollmentRepository enrollmentRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;
    public EnrollmentService (EnrollmentRepository enrollmentRepository,SubjectRepository subjectRepository, StudentRepository studentRepository){
        this.enrollmentRepository=enrollmentRepository;
        this.studentRepository=studentRepository;
        this.subjectRepository=subjectRepository;
    }

    @Transactional
    public EnrollmentViewDto createEnrollment(Long subjectId, Long studentId){
       Enrollment saved= enrollmentRepository.save(new Enrollment(studentRepository.findById(studentId).orElseThrow(),subjectRepository.findById(subjectId).orElseThrow()));
       return EnrollmentViewDto.fromEnrollment(saved);
    }

    @Transactional
    public List<EnrollmentViewDto> getAll(){
        return enrollmentRepository.findAll().stream().map(EnrollmentViewDto::fromEnrollment).toList();
    }

    @Transactional
    public List<EnrollmentViewDto> getByStudentId(Long studentId){
        return enrollmentRepository.findByStudentId(studentId).stream().map(EnrollmentViewDto::fromEnrollment).toList();
    }
}
