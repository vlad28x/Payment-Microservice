package ru.example.paymentservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.paymentservice.entities.AccountHistory;

@Repository
public interface AccountHistoryRepository extends JpaRepository<AccountHistory, Long> {
}
