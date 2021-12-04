package ru.example.paymentservice.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.example.paymentservice.dto.AccountHistoryRequestDto;
import ru.example.paymentservice.dto.AccountHistoryResponseDto;
import ru.example.paymentservice.services.AccountHistoryService;

import java.util.List;

@RestController
@RequestMapping("/history")
public class AccountHistoryController {

    private final AccountHistoryService accountHistoryService;

    public AccountHistoryController(AccountHistoryService accountHistoryService) {
        this.accountHistoryService = accountHistoryService;
    }

    @PreAuthorize("permitAll()")
    @GetMapping
    public ResponseEntity<List<AccountHistoryResponseDto>> getAllAccountHistory() {
        return ResponseEntity.ok(accountHistoryService.getAll());
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/{id}")
    public ResponseEntity<AccountHistoryResponseDto> getAccountHistoryById(@PathVariable Long id) {
        return ResponseEntity.ok(accountHistoryService.getById(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<AccountHistoryResponseDto> createAccountHistory(@RequestBody AccountHistoryRequestDto newAccountHistory) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accountHistoryService.add(newAccountHistory));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<AccountHistoryResponseDto> updateAccountHistory(@PathVariable Long id, @RequestBody AccountHistoryRequestDto newAccountHistory) {
        return ResponseEntity.ok(accountHistoryService.update(newAccountHistory));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void deleteAccountHistory(@PathVariable Long id) {
        accountHistoryService.delete(id);
    }
}
