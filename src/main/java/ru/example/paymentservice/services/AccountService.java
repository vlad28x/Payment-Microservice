package ru.example.paymentservice.services;

import ru.example.paymentservice.dto.AccountRequestDto;
import ru.example.paymentservice.dto.AccountResponseDto;
import ru.example.paymentservice.dto.DebtRequestDto;
import ru.example.paymentservice.dto.DebtResponseDto;

import java.util.List;

public interface AccountService {

    List<AccountResponseDto> getAll();

    AccountResponseDto getById(Long id);

    AccountResponseDto add(AccountRequestDto newAccount);

    AccountResponseDto update(AccountRequestDto newAccount);

    void delete(Long id);

    DebtResponseDto pay(DebtRequestDto currentDebt, String username);

}
