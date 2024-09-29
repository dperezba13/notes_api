package com.dperezba.notes_api.mapper;

import com.dperezba.notes_api.dto.UserCreateDTO;
import com.dperezba.notes_api.dto.UserDTO;
import com.dperezba.notes_api.dto.UserUpdateDTO;
import com.dperezba.notes_api.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private final ModelMapper modelMapper;

    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public UserDTO toDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }

    public User toUser(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public User toUser(UserCreateDTO userCreateDTO) {
        return modelMapper.map(userCreateDTO, User.class);
    }

    public User toUser(UserUpdateDTO userUpdateDTO, User user) {
        boolean originalSkipNullEnabled = modelMapper.getConfiguration().isSkipNullEnabled();

        try {
            modelMapper.getConfiguration().setSkipNullEnabled(true);
            modelMapper.map(userUpdateDTO, user);
        } finally {
            // Restaurar la configuración original
            modelMapper.getConfiguration().setSkipNullEnabled(originalSkipNullEnabled);
        }
        return user;
    }
}
