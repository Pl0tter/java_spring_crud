package com.example.homework10.service;

import com.example.homework10.model.Note;
import com.example.homework10.repository.NoteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@SpringBootTest
class NoteServiceIntegrationTest {
    @MockBean
    private NoteRepository noteRepository;
    @Autowired
    private NoteService noteService;

    @Test
    void addNote() {
        // Создаем заметку с заголовком и телом. Без даты.
        Note note = new Note();
        note.setHeader("Header");
        note.setBody("Body");

        // Настраиваем поведение репозитория
        when(noteRepository.save(note)).thenReturn(note);

        // Запускаем метод и сохраняем вернувшуюся заметку
        Note returnNote = noteService.addNote(note);

        // Проверяем был ли вызван у репозитория. Установлена ли дата.
        verify(noteRepository).save(note);
        assertFalse(returnNote.getCreationTime().toString().isEmpty());
    }

    @Test
    void deleteNote() {
        Long id = 10L;
        noteService.deleteNote(id);
        verify(noteRepository).deleteById(id);
    }
}