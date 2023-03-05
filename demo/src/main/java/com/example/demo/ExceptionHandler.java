package com.example.demo;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(IdAlreadyExistsException.class)
    public ResponseEntity<BaseResponse> IdExistsException() {
        return ResponseEntity.badRequest().body(new BaseResponse(ErrorCode.IdAlreadyExist));
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundUserProfileException.class)
    public ResponseEntity<BaseResponse> NotFoundUserProfileException() {
        return ResponseEntity.badRequest().body(new BaseResponse(ErrorCode.NotFoundUserProfileException));
    }
}
