package com.dperezba.notes_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class NoteCreateDTO {

    @NotBlank(message = "El titulo para la nota es obligatorio")
    @Size(min = 1, message = "El titulo de la nota debe tener al menos 1 caracter")
    public String title;

    public String body;

    @NotNull(message = "El orden para la nota es obligatorio")
    public Short numOrder;

    @NotNull(message = "El userId para la nota es obligatorio")
    private Integer userId;
}
