package com.example.tutoring.Teacher;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController{
    private final TeacherService teacherService;
    public TeacherController(TeacherService teacheService){this.teacherService=teacheService;}


    @GetMapping
    public List<TeacherViewDto> getAll(){
        return teacherService.getAll();
    }

    @GetMapping("/{id}")
        public TeacherViewDto getById(@PathVariable Long id){
            return teacherService.getById(id);
    }

    @PostMapping
    public ResponseEntity<TeacherViewDto> addTeacher(@RequestBody TeacherFormDto teacherformdto){
        TeacherViewDto t= teacherService.addTeacher(teacherformdto);
        URI location= URI.create("/teacher/"+t.id());
        return ResponseEntity.created(location).body(t);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeacherViewDto> updateTeacher(@RequestBody TeacherFormDto teacherFormDto,@PathVariable Long id){
            return ResponseEntity.ok(teacherService.updateTeacher(teacherFormDto,id));
    }
}