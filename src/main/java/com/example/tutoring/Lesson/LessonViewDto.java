package com.example.tutoring.Lesson;

import com.example.tutoring.Subject.Subject;

public record LessonViewDto (
        Long id,
        String title,
        int position,
        String content,
        Long subjectId
){
    public static LessonViewDto fromLesson(Lesson lesson) {
        return new LessonViewDto(lesson.getId(),lesson.getTitle(),lesson.getPosition(),lesson.getContent(),lesson.getSubject().getId());
    }
}
//id title, position content subject