package com.portfolio.portfolio.persistance.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_certification")
public class UserCeritifcation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_certification_id")
    private Long userCertificationId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "certification_id")
    private Certification certification;

    @Builder
    public UserCeritifcation(Long userCertificationId, User user, Certification certification) {
        this.userCertificationId = userCertificationId;
        this.user = user;
        this.certification = certification;
    }
}
