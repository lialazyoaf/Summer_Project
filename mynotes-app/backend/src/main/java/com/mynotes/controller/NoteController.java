package com.mynotes.controller;

import com.mynotes.model.Note;
import com.mynotes.repository.NoteRepository;

import java.util.List;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NoteController {

    @Autowired
    private NoteRepository repo;

    // show notes list
    @GetMapping("/")
    public String listNotes(Model model) {
        model.addAttribute("notes", repo.findAll());
        return "list";
    }

    // show new note details
    @GetMapping("/new")
    public String newNoteForm(Model model) {
        model.addAttribute("note", new Note());
        return "form";
    }

    // handle note form submission
    @PostMapping("/save")
    public String saveNote(@ModelAttribute Note note) {
        repo.save(note);
        return "redirect:/";
    }
    // Show the edit form, populated with the existing Note
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable String id, Model model) {
        Note note = repo.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("Invalid note Id: " + id));
        model.addAttribute("note", note);
        return "form";
}
    // Search notes by keyword
    @GetMapping("/search")
    public String searchNotes(@RequestParam String keyword, Model model) {
        List<Note> results = repo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(keyword, keyword);
        // if you want them newest-first:
        results.sort(Comparator.comparing(Note::getCreatedAt).reversed());
        model.addAttribute("notes", results);
        model.addAttribute("keyword", keyword);
        return "list";
    }
    
    //Deletes a note by id, then redirects back to the list.
    @PostMapping("/delete/{id}")
    public String deleteNote(@PathVariable String id) {
        repo.deleteById(id);
        return "redirect:/";
    }

}
