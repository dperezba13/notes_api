package com.dperezba.notes_api.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomFieldsErrorResponse {
    private LocalDateTime timestamp;
    private List<FieldErrorDetail> errors;
    private String details;
}
