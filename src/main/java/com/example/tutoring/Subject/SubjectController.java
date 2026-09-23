package com.example.tutoring.Subject;

import com.example.tutoring.security.CurrentUser;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private final SubjectService subjectService;
    public SubjectController(SubjectService subjectService){
            this.subjectService=subjectService;
    }

    @GetMapping
    public List<SubjectViewDto> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @PostMapping
    public ResponseEntity<SubjectViewDto> addSubject(@RequestBody SubjectFormDto sfd, @AuthenticationPrincipal CurrentUser currentUser){
        SubjectViewDto saved=subjectService.addSubject(sfd, currentUser.id());
        URI location= URI.create("/subjects/"+saved.id());
        return ResponseEntity.created(location).body(saved);
    }
    @GetMapping("/{id}")
    public SubjectViewDto getById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @PutMapping("/{id}")
    public SubjectViewDto updateSubject(@PathVariable Long id, @RequestBody SubjectFormDto sfd){
        return subjectService.updateSubject(sfd,id);
    }
}
