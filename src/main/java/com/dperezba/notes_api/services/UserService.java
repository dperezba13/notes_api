package com.dperezba.notes_api.services;

import com.dperezba.notes_api.dto.UserCreateDTO;
import com.dperezba.notes_api.dto.UserDTO;
import com.dperezba.notes_api.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getAllUsers();

    UserDTO getUser(Integer id);

    UserDTO addUser(UserCreateDTO userCreateDTO);

    UserDTO updateUser(Integer id, UserUpdateDTO userUpdateDTO);

    void deleteUser(Integer id);
}
