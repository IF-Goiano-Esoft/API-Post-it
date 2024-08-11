package com.swlo.postit.resources;

import com.swlo.postit.entities.dto.NewNoteDto;
import com.swlo.postit.entities.dto.NotesDto;
import com.swlo.postit.entities.dto.UpdateNoteDto;
import com.swlo.postit.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/notes")
public class NotesResource {

    private final NotesService notesService;

    @Autowired
    public NotesResource(NotesService notesService) {
        this.notesService = notesService;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteNoteById(@PathVariable Long id) {
        notesService.deleteNoteById(id);
    }

    @GetMapping("/get/{id}")
    public NotesDto getNoteById(@PathVariable Long id) {
        return notesService.getNoteById(id);
    }

    @PostMapping("/create")
    public void createNote(@RequestBody NewNoteDto rawNote, @RequestHeader("userId") Long userId) {
        notesService.createNote(rawNote, userId);
    }

    @GetMapping("/getall/{userId}")
    public List<NotesDto> getAllNotesByUserId(@PathVariable Long userId) {
        return notesService.getAllNotesByUserId(userId);
    }

    @PutMapping("/update/{id}")
    public void updateNoteById(@PathVariable Long id, @RequestBody UpdateNoteDto rawNote) {
        notesService.updateNoteById(id, rawNote);
    }
}
