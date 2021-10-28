package com.dtwo.rpgaction.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserRequest {
    private String username;
    private String password;
    private String email;
    private String role;
}
