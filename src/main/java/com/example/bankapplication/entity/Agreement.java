package com.example.bankapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;
import java.util.Objects;

@Table(name = "agreements")
@Getter
@Setter
public class Agreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "interest_rate")
    private double interestRate;
    @Column(name = "status")
    private int status;
    @Column(name = "sum")
    private double sum;
    @Column(name = "create_at")
    private Timestamp createAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agreement agreement = (Agreement) o;
        return id == agreement.id && Objects.equals(createAt, agreement.createAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createAt);
    }

    @Override
    public String toString() {
        return "Agreement{" +
                "id=" + id +
                ", interestRate=" + interestRate +
                ", status=" + status +
                ", sum=" + sum +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                ", product=" + product +
                ", account=" + account +
                '}';
    }
}