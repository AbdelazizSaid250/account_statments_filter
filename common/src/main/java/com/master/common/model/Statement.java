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
@Table(name = "statement")
@ToString
public class Statement {
    @Id
    @Column(name = "id", nullable = false)
    @Getter
    @Setter
    private int id;

    @Column(name = "account_id", nullable = false)
    @Getter
    @Setter
    private String accountID;

    @Column(name = "date_field", nullable = false)
    @Getter
    @Setter
    private String dateField;

    @Column(name = "amount", nullable = false)
    @Getter
    @Setter
    private String amount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Statement statement = (Statement) o;
        return id == statement.id
                && accountID.equals(statement.accountID)
                && dateField.equals(statement.dateField)
                && amount.equals(statement.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountID, dateField, amount);
    }
}
