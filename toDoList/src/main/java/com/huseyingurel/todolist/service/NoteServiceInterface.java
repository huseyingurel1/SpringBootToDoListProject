package com.huseyingurel.todolist.service;

import com.huseyingurel.todolist.entity.Note;

import java.util.List;

public interface NoteServiceInterface {

    List <Note> getAllNotes();

    Note saveNote(Note note);

    Note getNoteById(Long id);

    Note updateNote(Note note);

    void deleteById(Long id);


}
