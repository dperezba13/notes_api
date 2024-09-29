package com.dperezba.notes_api.mapper;

import com.dperezba.notes_api.dto.NoteCreateDTO;
import com.dperezba.notes_api.dto.NoteDTO;
import com.dperezba.notes_api.models.Note;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {
    private final ModelMapper modelMapper;

    public NoteMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public NoteDTO toDTO(Note note) {
        return modelMapper.map(note, NoteDTO.class);

    }

    public Note toNote(NoteCreateDTO noteCreateDTO) {
        return modelMapper.map(noteCreateDTO, Note.class);
    }

}
