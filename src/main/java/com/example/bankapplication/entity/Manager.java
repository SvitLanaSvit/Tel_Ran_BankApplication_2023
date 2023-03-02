package com.example.bankapplication.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

import static jakarta.persistence.CascadeType.*;

@Table(name = "managers")
@Getter
@Setter
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "status")
    private int status;
    @Column(name = "create_at")
    private Timestamp createAt;
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    @OneToMany(mappedBy = "manager", cascade = {MERGE, PERSIST, REFRESH}, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Client> clients;

    @OneToMany(mappedBy = "manager", cascade = {MERGE, PERSIST, REFRESH}, orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Objects.equals(firstName, manager.firstName) && Objects.equals(lastName, manager.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", createAt=" + createAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}