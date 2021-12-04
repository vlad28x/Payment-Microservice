package ru.example.paymentservice.entities;

import ru.example.paymentservice.entities.enums.Operation;

import javax.persistence.*;

@Entity
@Table(name = "account_history")
public class AccountHistory extends AbstractEntity {

    @Enumerated(EnumType.STRING)
    @Column(name = "operation")
    private Operation operation;

    @Column(name = "amount")
    private Integer amount;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
