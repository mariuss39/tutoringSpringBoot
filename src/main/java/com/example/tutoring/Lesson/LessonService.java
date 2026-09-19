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

    @Transactional
    public LessonViewDto updateLesson(LessonFormDto lfd, Long id){
       Lesson l= lessonRepository.findById(id).orElseThrow();
       l.setContent(lfd.content());
       l.setPosition(lfd.position());
       l.setTitle(lfd.title());
       //lipsesc din campuri
        return LessonViewDto.fromLesson(l);
    }

    @Transactional
    public void deleteLesson(Long id){
        Lesson deleted=lessonRepository.findById(id).orElseThrow();
        lessonRepository.delete(deleted);
    }

//title, position content subjectId
}
