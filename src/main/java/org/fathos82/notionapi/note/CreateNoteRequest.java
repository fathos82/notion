package org.fathos82.notionapi.note;

public record CreateNoteRequest(String title, String content, Long ownerUserId) {
}
