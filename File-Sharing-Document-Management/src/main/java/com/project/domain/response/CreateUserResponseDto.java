package com.project.domain.response;

import lombok.Builder;

@Builder
public record CreateUserResponseDto(String username, String email) {
}
