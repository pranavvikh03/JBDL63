package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.model.User;

@Getter
@Setter
@ToString
@Builder
public class UserResponseDto {

    private String message;

    private User user;
}
