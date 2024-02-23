package com.example.homework10.controller;

import com.example.homework10.model.Note;
import com.example.homework10.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> addNote(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.addNote(note), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return new ResponseEntity<>(noteService.findAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Note note = noteService.findNoteById(id);
        if (note != null) return new ResponseEntity<>(note, HttpStatus.OK);
        else return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Note> updateNote(@RequestBody Note note, @PathVariable Long id) {
        return new ResponseEntity<>(noteService.updateNote(id, note), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Note> deleteNote(@PathVariable Long id) {
        Note note = noteService.findNoteById(id);
        if (note != null) {
            noteService.deleteNote(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } else return ResponseEntity.badRequest().build();
    }

}
