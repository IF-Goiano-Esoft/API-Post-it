package com.swlo.postit.entities.dto.converters;

import com.swlo.postit.entities.Notes;
import com.swlo.postit.entities.dto.NotesDto;

import java.util.List;

public class NotesConverter {

    public static NotesDto toDto(Notes notes) {
        return new NotesDto(
                notes.getId(),
                notes.getTitle(),
                notes.getContent(),
                notes.getCreatedAt(),
                notes.getUpdatedAt(),
                notes.getColor()
        );
    }

    public static List<NotesDto> toDto(List<Notes> notesList) {
        return notesList.stream()
                .map(NotesConverter::toDto)
                .toList();
    }


}
