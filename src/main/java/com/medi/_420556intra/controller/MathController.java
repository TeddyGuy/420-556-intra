package com.medi._420556intra.controller;

import com.medi._420556intra.payload.request.TwoIntegersDto;
import com.medi._420556intra.payload.response.ResultingIntegerDto;
import com.medi._420556intra.service.MathService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping("/api/math")
@CrossOrigin
public class MathController {
    MathService mathService;

    @PostMapping("/add")
    ResponseEntity<ResultingIntegerDto> add(@Valid @RequestBody TwoIntegersDto dto){
        return ResponseEntity.ok(new ResultingIntegerDto(mathService.add(dto.a(),dto.b())));
    }

    @PostMapping("/subtract")
    ResponseEntity<ResultingIntegerDto> subtract(@Valid @RequestBody TwoIntegersDto dto){
        return ResponseEntity.ok(new ResultingIntegerDto(mathService.subtract(dto.a(),dto.b())));
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
