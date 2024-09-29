package com.dperezba.notes_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserUpdateDTO {
    @Size(min = 1, message = "El nombre no debe estar vacio")
    private String userName;

    @Size(min = 1, message = "El nombre de usuario no puede estar vacio")
    private String nickName;

    @Email(message = "El correo electrónico no es válido")
    @Size(min = 1, message = "El correo electrónico no puede estar vacio")
    private String userEmail;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String userPassword;
}
