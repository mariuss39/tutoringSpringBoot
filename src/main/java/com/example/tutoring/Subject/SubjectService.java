package com.example.tutoring.Subject;

import com.example.tutoring.Teacher.Teacher;
import com.example.tutoring.Teacher.TeacherRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URI;
import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;
    private final TeacherRepository teacherRepository;
    public SubjectService (SubjectRepository sp, TeacherRepository tp){
        this.subjectRepository=sp;
        this.teacherRepository=tp;
    }

    @Transactional(readOnly = true)
    public List<SubjectViewDto> getAllSubjects(){
        return subjectRepository.findAll().stream().map(SubjectViewDto::fromSubject).toList();
    }

    @Transactional(readOnly = true)
    public SubjectViewDto getSubjectById(Long id){
        return subjectRepository.findById(id).map(SubjectViewDto::fromSubject).orElseThrow();
    }

    @Transactional
    public SubjectViewDto addSubject(SubjectFormDto subjectFormDto,Long teacherId){
        Teacher t=teacherRepository.findById(teacherId).orElseThrow();
        Subject saved=subjectRepository.save(new Subject(subjectFormDto.name(),subjectFormDto.description(),t));
        return SubjectViewDto.fromSubject(saved);
    }

    @Transactional
    public SubjectViewDto updateSubject(SubjectFormDto sfd,Long id){
        Subject sbj= subjectRepository.findById(id).orElseThrow();
        sbj.setName(sfd.name());
        sbj.setDescription(sfd.description());
        //momentan nu am dto specializat deci nu am cum sa modific si teacher
        return SubjectViewDto.fromSubject(sbj);
    }

}
