package com.task.Tasks.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class LoginSingnResquest {

    @NotNull
    @Email
    private String email;
    @NotNull
    private String password;
}
