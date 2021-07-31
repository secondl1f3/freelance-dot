package com.dot.freelance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDto {

    private String id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String name;

    private Gender gender;

    @NotEmpty
    private String mobile;

    @NotEmpty
    private String email;

    private Boolean isDisabled;
}
