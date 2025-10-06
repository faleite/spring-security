package com.faleite.security.dto.request;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Email is mandatory ") String email,
                           @NotEmpty(message = "Password is mandatory") String password) {
}
