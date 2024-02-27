package com.example.homework11.service;

import com.example.homework11.model.Note;
import com.example.homework11.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;

    public Note addNote(Note note) {
        note.setCreationTime(LocalDateTime.now());
        return noteRepository.save(note);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Note findNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    public Note updateNote(Long id, Note note) {
        Note originalNote = noteRepository.findById(id).orElse(null);
        if (originalNote == null) {
            return noteRepository.save(note);
        } else {
            originalNote.setHeader(note.getHeader());
            originalNote.setBody(note.getBody());
            originalNote.setCreationTime(note.getCreationTime());
            return noteRepository.save(originalNote);
        }
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

}
