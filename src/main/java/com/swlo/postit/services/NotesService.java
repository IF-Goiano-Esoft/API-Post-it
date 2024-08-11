package com.swlo.postit.services;

import com.swlo.postit.entities.Notes;
import com.swlo.postit.entities.Users;
import com.swlo.postit.entities.dto.NewNoteDto;
import com.swlo.postit.entities.dto.NotesDto;
import com.swlo.postit.entities.dto.UpdateNoteDto;
import com.swlo.postit.entities.dto.converters.NotesConverter;
import com.swlo.postit.repositories.NotesRepository;
import com.swlo.postit.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class NotesService {

    private final NotesRepository notesRepository;
    private final UsersRepository usersRepository;

    @Autowired
    public NotesService(NotesRepository notesRepository, UsersRepository usersRepository) {
        this.notesRepository = notesRepository;
        this.usersRepository = usersRepository;
    }

    public void deleteNoteById(Long id) {
        notesRepository.deleteById(id);
    }

    public void createNote(NewNoteDto rawNote, Long userId) {
        Notes note = rawNote.toEntity();

        Optional<Users> user = usersRepository.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }

        note.setUser(user.get());


        notesRepository.save(note);
    }

    public void updateNoteById(Long id, UpdateNoteDto rawNote) {

        Notes note = notesRepository.findById(id).orElse(null);
        if (note == null) {
            throw new IllegalArgumentException("Note not found");
        }
        if (rawNote.title() != null) {
            note.setTitle(rawNote.title());
        }
        if (rawNote.content() != null) {
            note.setContent(rawNote.content());
        }
        if (rawNote.color() != null) {
            note.setColor(rawNote.color());
        }
        note.setUpdatedAt(Instant.now());

        notesRepository.save(note);
    }

    public NotesDto getNoteById(Long id) {
        Notes note = notesRepository.findById(id).orElse(null);
        if (note == null) {
            throw new IllegalArgumentException("Note not found");
        }
        return NotesConverter.toDto(note);

    }

    public List<NotesDto> getAllNotesByUserId(Long userId) {
        Optional<Users> user = usersRepository.findById(userId);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("User not found");
        }
        List<Notes> notes = user.get().getNotes();
        return NotesConverter.toDto(notes);
    }
}
