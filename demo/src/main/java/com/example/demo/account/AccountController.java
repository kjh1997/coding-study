package com.example.demo.account;

import com.example.demo.BaseResponse;
import com.example.demo.account.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @PostMapping("save")
    public ResponseEntity<BaseResponse> createAccount(@RequestBody AccountDTO accountDTO) {
        accountService.saveAccount(accountDTO);
        return ResponseEntity.ok(new BaseResponse<>(200, "회원가입에 성공하셨습니다."));
    }


    @GetMapping("profile/{name}")
    public ResponseEntity<BaseResponse> getProfile(@PathVariable String name) {
        AccountDTO result = accountService.getProfile(name);
        return ResponseEntity.ok(new BaseResponse<>(200, "정보를 찾았습니다.",result));
    }
}
