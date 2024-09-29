package com.dperezba.notes_api.controllers;

import com.dperezba.notes_api.dto.NoteCreateDTO;
import com.dperezba.notes_api.dto.NoteDTO;
import com.dperezba.notes_api.services.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NotesController {

    private final NoteService noteService;


    @GetMapping
    public ResponseEntity<List<NoteDTO>> getAllNotes() {
        return new ResponseEntity<>(noteService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NoteDTO> getNoteById(@PathVariable Integer id) {
        return new ResponseEntity<>(noteService.getNoteById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<NoteDTO> createNote(@Valid @RequestBody NoteCreateDTO noteCreateDTO) {
        return new ResponseEntity<>(noteService.createNote(noteCreateDTO), HttpStatus.CREATED);
    }


}
