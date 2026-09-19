package com.example.tutoring.Lesson;

import com.example.tutoring.Subject.SubjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;
    private final SubjectRepository subjectRepository;
    public LessonService (LessonRepository lessonRepository, SubjectRepository subjectRepository){
        this.lessonRepository=lessonRepository;
        this.subjectRepository=subjectRepository;
    }

    @Transactional
    public List<LessonViewDto> getBySubjectId(Long subjectId){
        return lessonRepository.findBySubjectId(subjectId).stream().map(LessonViewDto::fromLesson).toList();
    }

    @Transactional
    public LessonViewDto addLesson(LessonFormDto lessonFormDto, Long subjectId){
        Lesson saved=lessonRepository.save(new Lesson(lessonFormDto.title(),lessonFormDto.position(),lessonFormDto.content(),subjectRepository.findById(subjectId).orElseThrow()));
        return LessonViewDto.fromLesson(saved);
    }
//title, position content subjectId
}
