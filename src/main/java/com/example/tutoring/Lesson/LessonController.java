package com.example.tutoring.Lesson;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class LessonController {
    private final LessonService lessonService;
    public LessonController(LessonService lessonService){this.lessonService=lessonService;}

    @GetMapping("/subjects/{subjectId}/lessons")
    public List<LessonViewDto> getBySubjectId(@PathVariable Long subjectId){
        return lessonService.getBySubjectId(subjectId);
    }

    @PostMapping("/subjects/{subjectId}/lessons")
    public ResponseEntity<LessonViewDto> addLesson(@RequestBody LessonFormDto lfd, @PathVariable Long subjectId){
        LessonViewDto saved= lessonService.addLesson(lfd,subjectId);
        URI location= URI.create("/subjects/"+subjectId+"/lessons/"+saved.id());
        return ResponseEntity.created(location).body(saved);
    }

    @PutMapping("/lessons/{id}")
    public LessonViewDto updateLesson(@PathVariable Long id, @RequestBody LessonFormDto lfd){
        return lessonService.updateLesson(lfd,id);
    }

    @DeleteMapping("/lessons/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id){
        lessonService.deleteLesson(id);
        return ResponseEntity.noContent().build();
    }
}
