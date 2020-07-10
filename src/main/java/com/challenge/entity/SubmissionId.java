package com.challenge.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class SubmissionId implements Serializable {
    @ManyToOne
    private Challenge challenge;

    @ManyToOne
    private User user;
}