package com.task.Tasks.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class UsersResponse {

    private String email;
    private String password;
}
