package com.huseyingurel.todolist.service;

import com.huseyingurel.todolist.entity.Note;
import com.huseyingurel.todolist.repository.NoteRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteServiceInterface {

    private NoteRepository noteRepository;

    public NoteServiceImpl( NoteRepository noteRepository){
        super();
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public Note updateNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public void deleteById(Long id) {
        noteRepository.deleteById(id);

    }
}
