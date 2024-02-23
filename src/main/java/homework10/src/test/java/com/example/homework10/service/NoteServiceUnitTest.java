package com.example.homework10.service;

import com.example.homework10.model.Note;
import com.example.homework10.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.mockito.BDDMockito.given;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NoteServiceUnitTest {
    private NoteRepository noteRepository;
    private NoteService noteService;

    @BeforeEach
    void setUp() {
        noteRepository = mock(NoteRepository.class);
        noteService = new NoteService(noteRepository);

    }

    @Test
    void addNote() {
        // Создаем заметку с заголовком и телом. Без даты.
        Note note = new Note();
        note.setHeader("Header");
        note.setBody("Body");

        // Настраиваем поведение репозитория
        given(noteRepository.save(note)).willReturn(note);

        // Запускаем метод и сохраняем вернувшуюся заметку
        Note returnNote = noteService.addNote(note);

        // Проверяем был ли вызван метод у репозитория. Установлена ли дата.
        verify(noteRepository).save(note);
        assertFalse(returnNote.getCreationTime().toString().isEmpty());
    }

    @Test
    void updateNote() {
        // Создаем заметки с заголовком и телом.
        Note originalNote = new Note();
        originalNote.setId(1L);
        originalNote.setHeader("Header");
        originalNote.setBody("Body");
        originalNote.setCreationTime(LocalDateTime.now());

        Note updatedNote = new Note();
        updatedNote.setId(1L);
        updatedNote.setHeader("New Header");
        updatedNote.setBody("New Body");
        updatedNote.setCreationTime(LocalDateTime.now());

        // Настраиваем поведение
        given(noteRepository.findById(originalNote.getId())).willReturn(Optional.of(originalNote));
        noteService.updateNote(originalNote.getId(), updatedNote);

        // Проверяем вызов методов репозитория
        verify(noteRepository).findById(originalNote.getId());
        verify(noteRepository).save(updatedNote);
    }

    @Test
    void deleteNote() {
        Long id = 10L;
        noteService.deleteNote(id);
        verify(noteRepository).deleteById(id);
    }
}