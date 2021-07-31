package com.dot.freelance.domain;

import com.dot.freelance.common.BaseDomain;
import com.dot.freelance.dto.Gender;
import lombok.*;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "account")
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Where(clause = "IS_DELETED=false")
public class Account extends BaseDomain implements Serializable {

    @Column(name = "USERNAME", length = 100, unique = true)
    private String username;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "GENDER", length = 8)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "MOBILE", length = 20, unique = true)
    private String mobile;

    @Column(name = "EMAIL", length = 100, unique = true)
    private String email;

    private Boolean isDisabled;

    @Builder
    public Account(String id, LocalDateTime createAt, LocalDateTime updateAt, Boolean isDeleted, String name, Gender gender,
                   String mobile, String email,  String username, Boolean isDisabled) {
        super(id, createAt, updateAt, isDeleted);
        this.name = name;
        this.gender = gender;
        this.mobile = mobile;
        this.email = email;
        this.username = username;
        this.isDisabled = isDisabled;
    }
}
