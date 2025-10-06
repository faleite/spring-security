package com.faleite.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record RegisterUserRequest(@NotEmpty(message = "Name is mandatory ") String name,
                                  @NotEmpty(message = "E-mail is mandatory ") String email,
                                  @NotEmpty(message = "Password is mandatory") String password) {
}
