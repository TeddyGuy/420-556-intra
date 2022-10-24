package com.medi._420556intra.payload.request;

import lombok.NonNull;

import javax.validation.constraints.NotNull;

public record TwoIntegersDto(
        @NotNull(message = "required") Integer a,
        @NotNull(message = "required") Integer b) {
}
