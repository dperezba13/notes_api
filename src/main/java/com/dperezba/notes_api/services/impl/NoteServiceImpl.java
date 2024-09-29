package com.dperezba.notes_api.services.impl;

import com.dperezba.notes_api.dto.NoteCreateDTO;
import com.dperezba.notes_api.dto.NoteDTO;
import com.dperezba.notes_api.exception.ResourceNotFoundExcception;
import com.dperezba.notes_api.mapper.NoteMapper;
import com.dperezba.notes_api.models.Note;
import com.dperezba.notes_api.models.User;
import com.dperezba.notes_api.repository.NoteRepository;
import com.dperezba.notes_api.repository.UserRepository;
import com.dperezba.notes_api.services.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NoteServiceImpl implements NoteService {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;
    private final NoteMapper noteMapper;

    @Override
    public List<NoteDTO> getAllNotes() {
        List<Note> notes = noteRepository.findAll();
        return notes.stream().map(noteMapper::toDTO).toList();
    }

    @Override
    public NoteDTO getNoteById(Integer id) {
        Note note = noteRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcception("No se encontró la nota"));
        return noteMapper.toDTO(note);
    }

    @Override
    public NoteDTO createNote(NoteCreateDTO noteCreateDTO) {
        User user = userRepository.findById(noteCreateDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundExcception("No se encontró el usuario con id: " + noteCreateDTO.getUserId()));

        Note note = noteMapper.toNote(noteCreateDTO);
        note.setUser(user);
        note.setStatus((short) 1);
        note.setCreatedAt(LocalDateTime.now());
        note = noteRepository.save(note);
        return noteMapper.toDTO(note);
    }

    @Override
    public NoteDTO updateNote(NoteDTO note) {
        return null;
    }

    @Override
    public void deleteNote(Integer id) {

    }
}
