package org.fathos82.notionapi.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("notes")
public class NoteController {
    @Autowired
    private NoteService noteService;

    @PostMapping("/create")
    public ResponseEntity<NoteResponse> createNote(@RequestBody CreateNoteRequest noteRequest) {
        return ResponseEntity.ok(noteService.createNote(noteRequest));
    }

    @GetMapping("/get")
    public ResponseEntity<NoteResponse> getNote(Long id) {
        return ResponseEntity.ok(noteService.findNoteById(id));
    }
}
