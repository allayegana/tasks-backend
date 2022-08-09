package com.task.Tasks.http;

import com.task.Tasks.Response.UsersResponse;
import com.task.Tasks.request.LoginSingnResquest;
import com.task.Tasks.request.UsersRequest;
import com.task.Tasks.useCase.UsersUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path = "/signup")
public class UsersControllers {

    @Autowired
    private UsersUseCase usersUseCase;

    @PostMapping(path = "cadastro/usuarios", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void signSalvo(@Valid @RequestBody UsersRequest usersRequest) {
        usersUseCase.signSalvo(usersRequest);
    }

    @PostMapping(path = "sign/validar", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public UsersResponse ValidarLogin(@Valid @RequestBody LoginSingnResquest loginSignRequest) {
       return usersUseCase.ValidarLogin(loginSignRequest);
    }
}
