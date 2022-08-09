package com.task.Tasks.builder;

import com.task.Tasks.Response.UsersResponse;
import com.task.Tasks.entity.Users;
import com.task.Tasks.request.UsersRequest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsersBuilder {
    @SneakyThrows
    public Users build(UsersRequest usersRequest) {
        if (usersRequest == null) {
            throw new Exception("nao pode ser null ");
        }
        return Users
                .builder()
                .email(usersRequest.getEmail())
                .nome(usersRequest.getNome())
                .password(usersRequest.getPassword())
                .build();
    }


    public UsersResponse buildValidte(Users entity) {

        return UsersResponse
                .builder()
                .email(entity.getEmail())
                .password(entity.getPassword())
                .build();
    }

    public UsersResponse msg(Users entity) {

        return UsersResponse
                .builder()
                .password(" Usuario ou senha inavavido porfavor tenta novamente !!!")
                .build();
    }
}
