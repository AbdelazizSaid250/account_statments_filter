package com.master.common.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "account")
@ToString
public class Account {
    @Id
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private int id;

    @Column(name = "account_type", nullable = false)
    @Getter
    @Setter
    private String accountType;

    @Column(name = "account_number", nullable = false)
    @Getter
    @Setter
    private String accountNumber;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id == account.id
                && accountType.equals(account.accountType)
                && accountNumber.equals(account.accountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountType, accountNumber);
    }
}
