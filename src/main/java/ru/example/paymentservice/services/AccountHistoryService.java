package ru.example.paymentservice.services;

import ru.example.paymentservice.dto.AccountHistoryRequestDto;
import ru.example.paymentservice.dto.AccountHistoryResponseDto;

import java.util.List;

public interface AccountHistoryService {

    List<AccountHistoryResponseDto> getAll();

    AccountHistoryResponseDto getById(Long id);

    AccountHistoryResponseDto add(AccountHistoryRequestDto newAccountHistory);

    AccountHistoryResponseDto update(AccountHistoryRequestDto newAccountHistory);

    void delete(Long id);

}
