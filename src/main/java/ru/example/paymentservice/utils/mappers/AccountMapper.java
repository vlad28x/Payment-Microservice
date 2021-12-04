package ru.example.paymentservice.utils.mappers;

import org.mapstruct.Mapper;
import ru.example.paymentservice.dto.AccountRequestDto;
import ru.example.paymentservice.dto.AccountResponseDto;
import ru.example.paymentservice.entities.Account;

@Mapper
public abstract class AccountMapper {

    public abstract AccountResponseDto accountToAccountResponseDto(Account account);

    public abstract Account accountRequestDtoToAccount(AccountRequestDto account);

}
