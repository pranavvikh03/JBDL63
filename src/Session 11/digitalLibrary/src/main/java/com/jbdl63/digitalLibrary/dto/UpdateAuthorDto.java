package com.jbdl63.digitalLibrary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAuthorDto {

    @NotNull(message = "Author Id should not be null")
    private Integer authorId;

    @NotBlank(message = "Author Address should be Null or Blank")
    private String address;
}
