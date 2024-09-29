package com.dperezba.notes_api.dto;

import lombok.Data;

@Data
public class NoteDTO {
    public Integer noteId;
    public String title;
    public String body;
    public Short numOrder;
    private Integer userId;
}
