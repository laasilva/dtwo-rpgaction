package com.dtwo.rpgaction.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@Builder
public class GenericResponse {
    private String message;
    private HttpStatus status;
}
