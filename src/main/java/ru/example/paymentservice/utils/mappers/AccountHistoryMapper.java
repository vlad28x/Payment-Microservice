package ru.example.paymentservice.utils.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.example.paymentservice.dto.AccountHistoryRequestDto;
import ru.example.paymentservice.dto.AccountHistoryResponseDto;
import ru.example.paymentservice.entities.AccountHistory;

@Mapper
public abstract class AccountHistoryMapper {

    @Mapping(source = "account.id", target = "accountId")
    public abstract AccountHistoryResponseDto accountHistoryToAccountHistoryResponseDto(AccountHistory accountHistory);

    @Mapping(source = "accountId", target = "account.id")
    public abstract AccountHistory accountHistoryRequestDtoToAccountHistory(AccountHistoryRequestDto accountHistory);


}
