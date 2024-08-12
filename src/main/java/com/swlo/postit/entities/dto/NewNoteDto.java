package com.swlo.postit.entities.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.swlo.postit.entities.Notes;

import java.io.Serializable;
import java.time.Instant;

public record NewNoteDto(
        String title,
        String content,
        String color
) implements Serializable {
    public Notes toEntity() {
        return new Notes(title, content, color);
    }
}
