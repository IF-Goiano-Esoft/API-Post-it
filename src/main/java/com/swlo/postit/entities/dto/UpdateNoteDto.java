package com.swlo.postit.entities.dto;

public record UpdateNoteDto(
        String title,
        String content,
        String color
) {
}
