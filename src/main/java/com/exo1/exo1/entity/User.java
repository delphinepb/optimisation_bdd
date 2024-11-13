package com.exo1.exo1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "users", indexes = {
        @Index(name = "idx_users_email", columnList = "email"),
        @Index(name = "idx_users_name", columnList = "name")})
@NamedEntityGraph(
        name = "user-projet-task-graph",
        attributeNodes = {
                @NamedAttributeNode("projets"),
                @NamedAttributeNode("task")
        }
)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long id;

    private String name;
    private String email;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "users_projet", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "projet_id"))
    private Set<Projet> projets;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Task task;

}
