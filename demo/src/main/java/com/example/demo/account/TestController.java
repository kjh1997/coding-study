package com.example.demo.account;


import com.example.demo.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/")
    public ResponseEntity<BaseResponse> testControl() {

        return ResponseEntity.ok(new BaseResponse<>(400,"fail"));
    }
}
