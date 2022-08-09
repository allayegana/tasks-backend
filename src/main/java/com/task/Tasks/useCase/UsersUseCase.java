package com.task.Tasks.useCase;

import com.task.Tasks.Repository.UsersRepository;
import com.task.Tasks.RepositoryFacade.UsersRepositoryFacade;
import com.task.Tasks.Response.UsersResponse;
import com.task.Tasks.builder.UsersBuilder;
import com.task.Tasks.entity.Users;
import com.task.Tasks.exception.ValideUsersNotFoundException;
import com.task.Tasks.request.LoginSingnResquest;
import com.task.Tasks.request.UsersRequest;
import lombok.SneakyThrows;
import org.hibernate.annotations.NotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;

@Service
public class UsersUseCase {

    @Autowired
    private UsersRepositoryFacade usersRepositoryFacade;

    @Autowired
    private UsersRepository repository;

    @Autowired
    private UsersBuilder builder;


    public void signSalvo(UsersRequest usersRequest) {
        usersRepositoryFacade.salvar(usersRequest);
    }




    @SneakyThrows
    public UsersResponse ValidarLogin(LoginSingnResquest loginSignRequest) {

        Users entity = repository.findByPassword(loginSignRequest.getPassword());

        if (entity.getPassword().equals(loginSignRequest.getPassword()) &&
                    entity.getEmail().equals(loginSignRequest.getEmail())) {
                return builder.buildValidte(entity);
            }else {
            return null;
        }
    }
}
