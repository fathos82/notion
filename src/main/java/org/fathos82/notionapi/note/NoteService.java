package org.fathos82.notionapi.note;


import org.fathos82.notionapi.note.errors.NoteNotFoundException;
import org.fathos82.notionapi.user.User;
import org.fathos82.notionapi.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class NoteService {
    @Autowired
    private UserService userService;
    @Autowired
    private NoteRepository noteRepository;

    public NoteResponse findNoteById(long noteId)  {

        Optional<Note> optionalNote = noteRepository.findById(noteId);
        Note note = optionalNote.orElseThrow(() -> new NoteNotFoundException("No note found with ID: " + noteId));
        return new NoteResponse(note);
    }

    public NoteResponse createNote(CreateNoteRequest createNoteRequest) {
        Note note = new Note();
        // todo: testar tratamento de eeros
        User user =  userService.findUserById(createNoteRequest.ownerUserId());
        note.setOwnerUser(user);
        note.setTitle(createNoteRequest.title());
        note.setContent(createNoteRequest.content());
        note.updateDate();
        note = noteRepository.save(note);
        return new NoteResponse(note);

    }
}
