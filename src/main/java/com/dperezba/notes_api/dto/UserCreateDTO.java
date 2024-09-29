package com.dperezba.notes_api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserCreateDTO {

    @NotBlank(message = "El nombre obligatorio")
    private String userName;

    @NotBlank(message = "El nombre de usuario es obligatorio")
    private String nickName;

    @Email(message = "El correo electrónico no es válido")
    @NotBlank(message = "El correo electrónico es obligatorio")
    private String userEmail;

    @NotBlank(message = "La contrasña es obligatoria")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String userPassword;
}
