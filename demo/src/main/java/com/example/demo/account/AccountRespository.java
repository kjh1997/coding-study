package com.example.demo.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRespository extends JpaRepository<Account, Long> {
    boolean existsByName(String name);

    Account findByName(String name);

    Optional<Account> findById(Long id);
}
