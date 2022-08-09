package com.task.Tasks.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UsersRequest {
    @NotNull
    private String nome;

    @NotNull
    @Email
    @Column(unique = false)
    private String email;

    @NotNull
    private String password;
}
