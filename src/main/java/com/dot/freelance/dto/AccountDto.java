package com.dot.freelance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {
    private String username;

    private String name;

    private Gender gender;

    private String mobile;

    private String email;

    private Boolean isDisabled;
}
