package com.dperezba.notes_api.services.impl;

import com.dperezba.notes_api.dto.UserCreateDTO;
import com.dperezba.notes_api.dto.UserDTO;
import com.dperezba.notes_api.dto.UserUpdateDTO;
import com.dperezba.notes_api.exception.BadRequestException;
import com.dperezba.notes_api.exception.ResourceNotFoundExcception;
import com.dperezba.notes_api.mapper.UserMapper;
import com.dperezba.notes_api.models.User;
import com.dperezba.notes_api.repository.UserRepository;
import com.dperezba.notes_api.services.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final ModelMapper modelMapper;


    @Override
    public UserDTO getUser(Integer id) {
        User user = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcception("Usuario no encontrado"));
        return this.userMapper.toDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream().map(this.userMapper::toDTO).toList();
    }

    @Override
    public UserDTO addUser(UserCreateDTO userCreateDTO) {
        boolean existsByEmail = userRepository.existsByUserEmailAndStatus(userCreateDTO.getUserEmail(), (short) 1);
        boolean existsByNickName = userRepository.existsByNickNameAndStatus(userCreateDTO.getNickName(), (short) 1);

        if (existsByEmail) {
            throw new BadRequestException("Ya existe un usuario con ese email");
        }
        if (existsByNickName) {
            throw new BadRequestException("Ya existe un usuario con ese nombre de usuario");
        }

        User user = userMapper.toUser(userCreateDTO);
        user.setStatus((short) 1);
        user.setCreatedAt(LocalDateTime.now());
        user = userRepository.save(user);
        return userMapper.toDTO(user);
    }

    @Override
    public UserDTO updateUser(Integer id, UserUpdateDTO userUpdateDTO) {
        User userFound = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundExcception("Uusario no encontrado"));

        if (userUpdateDTO.getNickName() != null && userRepository.existsByNickNameAndStatusAndUserIdIsNot(userUpdateDTO.getNickName(), (short) 1, id)) {
            throw new BadRequestException("Ya existe un usuario con ese nombre de usuario");
        }

        if (userUpdateDTO.getUserEmail() != null && userRepository.existsByUserEmailAndStatusAndUserIdIsNot(userUpdateDTO.getUserEmail(), (short) 1, id)) {
            throw new BadRequestException("Ya existe un usuario con ese email");
        }

        if(userUpdateDTO.getUserPassword() != null && userUpdateDTO.getUserPassword().equals(userFound.getUserPassword())){
            throw new BadRequestException("Ya existe un usuario con ese password");
        }

        userFound.setUpdatedAt(LocalDateTime.now());
        userFound = userMapper.toUser(userUpdateDTO, userFound);
        userFound = userRepository.save(userFound);
        return userMapper.toDTO(userFound);
    }


    @Override
    public void deleteUser(Integer id) {

    }

}
