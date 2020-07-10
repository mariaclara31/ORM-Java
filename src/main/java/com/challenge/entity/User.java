package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@EntityListeners(AuditingEntityListener.class)
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column
    @Size(max = 100)
    private String fullName;

    @Email
    @NotNull
    @Size(max = 100)
    private String email;

    @Column
    @Email
    @NotNull
    @Size(max = 50)
    private String nickname;

    @Column
    @NotNull
    @Size(max = 255)
    private String password;

    @CreatedDate
    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "id.user")
    private List<Candidate> candidates;

    @OneToMany(mappedBy = "id.user")
    private List<Submission> submissions;
}