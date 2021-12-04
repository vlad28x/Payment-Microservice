package ru.example.paymentservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import ru.example.paymentservice.dto.AccountRequestDto;
import ru.example.paymentservice.dto.AccountResponseDto;
import ru.example.paymentservice.dto.DebtRequestDto;
import ru.example.paymentservice.dto.DebtResponseDto;
import ru.example.paymentservice.services.AccountService;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<AccountResponseDto>> getAllAccounts() {
        return ResponseEntity.ok(accountService.getAll());
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/{id}")
    public ResponseEntity<AccountResponseDto> getAccountById(@PathVariable Long id) {
        return ResponseEntity.ok(accountService.getById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<AccountResponseDto> createAccount(@RequestBody AccountRequestDto newAccount) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.add(newAccount));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDto> updateAccount(@PathVariable Long id, @RequestBody AccountRequestDto newAccount) {
        return ResponseEntity.ok(accountService.update(newAccount));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.delete(id);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PutMapping("/pay")
    public ResponseEntity<DebtResponseDto> payDebt(@RequestHeader("Authorization") String jwt, @RequestBody DebtRequestDto debt, @AuthenticationPrincipal User user) {
        return ResponseEntity.ok(accountService.pay(debt, user.getUsername()));
    }
}
