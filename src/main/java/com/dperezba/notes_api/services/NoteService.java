package com.dperezba.notes_api.services;

import com.dperezba.notes_api.dto.NoteCreateDTO;
import com.dperezba.notes_api.dto.NoteDTO;

import java.util.List;

public interface NoteService {
    public List<NoteDTO> getAllNotes();
    public NoteDTO getNoteById(Integer id);
    public NoteDTO createNote(NoteCreateDTO noteCreateDTO);
    public NoteDTO updateNote(NoteDTO note);
    public void deleteNote(Integer id);
}
