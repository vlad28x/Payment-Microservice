package ru.example.paymentservice.services.impls;

import org.mapstruct.factory.Mappers;
import org.springframework.core.NestedRuntimeException;
import org.springframework.stereotype.Service;
import ru.example.paymentservice.dto.AccountHistoryRequestDto;
import ru.example.paymentservice.dto.AccountHistoryResponseDto;
import ru.example.paymentservice.exceptions.BadRequestException;
import ru.example.paymentservice.exceptions.NotFoundException;
import ru.example.paymentservice.repositories.AccountHistoryRepository;
import ru.example.paymentservice.services.AccountHistoryService;
import ru.example.paymentservice.utils.mappers.AccountHistoryMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountHistoryServiceImpl implements AccountHistoryService {

    private static final AccountHistoryMapper accountHistoryMapper = Mappers.getMapper(AccountHistoryMapper.class);

    private final AccountHistoryRepository accountHistoryRepository;

    public AccountHistoryServiceImpl(AccountHistoryRepository accountHistoryRepository) {
        this.accountHistoryRepository = accountHistoryRepository;
    }

    @Override
    public List<AccountHistoryResponseDto> getAll() {
        return accountHistoryRepository.findAll().stream()
                .map(accountHistoryMapper::accountHistoryToAccountHistoryResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public AccountHistoryResponseDto getById(Long id) {
        return accountHistoryMapper.accountHistoryToAccountHistoryResponseDto(accountHistoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException(String.format("AccountHistory with ID %s not found", id))));
    }

    @Override
    public AccountHistoryResponseDto add(AccountHistoryRequestDto newAccountHistory) {
        try {
            return accountHistoryMapper.accountHistoryToAccountHistoryResponseDto(
                    accountHistoryRepository.save(accountHistoryMapper.accountHistoryRequestDtoToAccountHistory(newAccountHistory))
            );
        } catch (NestedRuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public AccountHistoryResponseDto update(AccountHistoryRequestDto newAccountHistory) {
        try {
            return accountHistoryMapper.accountHistoryToAccountHistoryResponseDto(
                    accountHistoryRepository.save(accountHistoryMapper.accountHistoryRequestDtoToAccountHistory(newAccountHistory))
            );
        } catch (NestedRuntimeException e) {
            throw new BadRequestException(e.getMessage());
        }
    }

    @Override
    public void delete(Long id) {
        accountHistoryRepository.deleteById(id);
    }
}
