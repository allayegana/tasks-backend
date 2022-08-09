package com.task.Tasks.RepositoryFacade;

import com.task.Tasks.Response.UsersResponse;
import com.task.Tasks.request.LoginSingnResquest;
import com.task.Tasks.request.UsersRequest;

public interface UsersRepositoryFacade {
    void salvar(UsersRequest usersRequest);

    UsersResponse validarSign(String password);
}
