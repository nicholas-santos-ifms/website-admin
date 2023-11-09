package br.edu.ifms.websiteadmin.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class RestResponseEntityFormExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public List<FormFileldErrorValidationDto> handle(MethodArgumentNotValidException exception) {
        List<FormFileldErrorValidationDto> dto = new ArrayList<>();

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        fieldErrors.forEach(e -> {
            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
            FormFileldErrorValidationDto erro = new FormFileldErrorValidationDto.Builder()
                    .campo(e.getField())
                    .erro(mensagem)
                    .build();
            dto.add(erro);
        });

        return dto;
    }
    
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ResponseStatusException.class)
    public MessageDto handle(ResponseStatusException exception) {
        return new MessageDto(HttpStatus.BAD_REQUEST.value(), 
                exception.getReason(), exception.getMessage());
    }
    
    @ResponseStatus(code = HttpStatus.FORBIDDEN)
    @ExceptionHandler(AuthenticationException.class)
    public MessageDto handle(AuthenticationException exception) {
        return new MessageDto(HttpStatus.FORBIDDEN.value(), 
                exception.getMessage());
    }

}
