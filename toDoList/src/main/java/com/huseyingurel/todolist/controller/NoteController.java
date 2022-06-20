package com.huseyingurel.todolist.controller;


import com.huseyingurel.todolist.entity.Note;
import com.huseyingurel.todolist.service.NoteServiceInterface;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class NoteController {

    private NoteServiceInterface noteServiceInterface;

    public NoteController(NoteServiceInterface noteServiceInterface){
        super();
        this.noteServiceInterface = noteServiceInterface;
    }

    // list

    @GetMapping("/notes")
    public String listNotes(Model model){
        model.addAttribute("notes",noteServiceInterface.getAllNotes());
        return "notes";
    }

    // adding screen
    @GetMapping("/notes/new")
    public String createNoteForm(Model model){
        Note note = new Note();
        model.addAttribute("note",note);
        return "create_note";
    }

    // adding method

    @PostMapping("/notes")
    public String saveNote(@ModelAttribute("note") Note note){
        noteServiceInterface.saveNote(note);
         return "redirect:/notes";
    }

    //id ye göre getirme
    @GetMapping("/notes/edit/{id}")
    public String editNoteForm(@PathVariable Long id, Model model){
        model.addAttribute("note",noteServiceInterface.getNoteById(id));
        return "edit_note";
    }

    //Düzenleme

    @PostMapping("/notes/{id}")
    public String updateNotes(@PathVariable Long id,
            @ModelAttribute("note") Note note, Model model){

        Note existingNote = noteServiceInterface.getNoteById(id);
        existingNote.setId(id);
        existingNote.setTitleSection(note.getTitleSection());
        existingNote.setMessageSection(note.getMessageSection());

        noteServiceInterface.updateNote(existingNote);

        return "redirect:/notes";
    }

    //Silme
    @GetMapping("/notes/{id}")
    public String deleteNotes(@PathVariable Long id){
        noteServiceInterface.deleteById(id);
        return "redirect:/notes";
    }


}
