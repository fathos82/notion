package org.fathos82.notionapi.note;

import java.time.LocalDateTime;

public record  NoteResponse(Long id, String title, String content, LocalDateTime createdAt, LocalDateTime updateAt, long userId) {

    public NoteResponse(Note note) {
        this(note.getId(), note.getTitle(), note.getContent(), note.getCreatedAt(), note.getUpdatedAt(), note.getOwnerUser().getId());
    }
}
