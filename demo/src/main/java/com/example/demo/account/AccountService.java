package com.example.demo.account;

import com.example.demo.IdAlreadyExistsException;
import com.example.demo.NotFoundUserProfileException;
import com.example.demo.account.dto.AccountDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRespository accountRespository;

    public void saveAccount(AccountDTO accountDTO) {
        if (accountRespository.existsByName(accountDTO.getName())) {
            throw new IdAlreadyExistsException();
        }
        Account account = Account.builder().name(accountDTO.getName()).role(accountDTO.getRole()).build();
        accountRespository.save(account);
    }

    public AccountDTO getProfile(String name) {
        if (accountRespository.existsByName(name)) {
            Account account = accountRespository.findByName(name);
            return AccountDTO.builder().name(account.getName()).role(account.getRole()).build();
        } else {
            throw new NotFoundUserProfileException();
        }
    }
}
