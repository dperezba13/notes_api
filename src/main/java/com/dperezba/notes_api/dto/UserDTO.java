package com.dperezba.notes_api.dto;

import lombok.Data;

@Data
public class UserDTO {
    public Integer userId;
    public String userName;
    public String nickName;
    public String userEmail;
}
