package com.trungvq.kafkaexample.model;

import java.time.LocalDateTime;

public record Message(
        String message,
        LocalDateTime createdAt
) {
}
