package org.example.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class UserWalletCreationRequest {

    private Long userId;

    private String userName;

    private String userEmailId;
}
