package com.example.tutoring.Teacher;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherService{
    private final TeacherRepository teacherRepository;
    private final PasswordEncoder passwordEncoder;
    public TeacherService(TeacherRepository teacherRepository, PasswordEncoder pe){
        this.teacherRepository=teacherRepository;
        this.passwordEncoder=pe;
    }

    @Transactional (readOnly = true)
    public List<TeacherViewDto> getAll(){
        return teacherRepository.findAll().stream().map(TeacherViewDto::fromTeacher).toList();
    }

    @Transactional(readOnly = true)
    public TeacherViewDto getById(Long id){
        return teacherRepository.findById(id).map(TeacherViewDto::fromTeacher).orElseThrow();
    }

    @Transactional
    public	TeacherViewDto addTeacher (TeacherFormDto teacherFormDto){
        Teacher saved=new Teacher(teacherFormDto.name(), teacherFormDto.email(),passwordEncoder.encode(teacherFormDto.password()),teacherFormDto.description());
        return TeacherViewDto.fromTeacher(teacherRepository.save(saved));
    }

    @Transactional
    public TeacherViewDto updateTeacher(TeacherFormDto teacherFormDto,Long id){
            Teacher t=teacherRepository.findById(id).orElseThrow();
            t.setDescription(teacherFormDto.description());
            t.setName(teacherFormDto.name());
            t.setEmail(teacherFormDto.email());
            return TeacherViewDto.fromTeacher(t);
    }
}
