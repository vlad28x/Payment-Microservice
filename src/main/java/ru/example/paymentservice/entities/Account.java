package ru.example.paymentservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "account")
public class Account extends AbstractEntity {

    @Column(name = "account_username")
    private String username;

    @Column(name = "account_balance")
    private Integer balance;

    @OneToMany(mappedBy = "account")
    private List<AccountHistory> accountHistory;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public List<AccountHistory> getAccountHistory() {
        return accountHistory;
    }

    public void setAccountHistory(List<AccountHistory> accountHistory) {
        this.accountHistory = accountHistory;
    }
}
