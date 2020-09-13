package com.fedoseev.demoprject.service;

import com.fedoseev.demoprject.model.Note;
import com.fedoseev.demoprject.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public void addNote(Note note) {
       noteRepository.save(note);
    }
}
