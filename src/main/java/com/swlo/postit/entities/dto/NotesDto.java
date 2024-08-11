package com.swlo.postit.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swlo.postit.entities.Notes;

import java.io.Serializable;
import java.time.Instant;

public record NotesDto(
        Long id,
        String title,
        String content,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
        Instant createdAt,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", timezone = "GMT")
        Instant updatedAt,
        String color

) implements Serializable {
    public Notes toEntity(Long id) {
        return new Notes(id, title, content, createdAt, updatedAt, color);
    }

    public static NotesDto fromEntity(Notes notes) {
        return new NotesDto(notes.getId(), notes.getTitle(), notes.getContent(), notes.getCreatedAt(), notes.getUpdatedAt(), notes.getColor());
    }
}
