package com.task.Tasks.RepositoryFacadeImpl;

import com.task.Tasks.Repository.UsersRepository;
import com.task.Tasks.RepositoryFacade.UsersRepositoryFacade;
import com.task.Tasks.Response.UsersResponse;
import com.task.Tasks.builder.UsersBuilder;
import com.task.Tasks.entity.Users;
import com.task.Tasks.request.UsersRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersRepositoryImpl implements UsersRepositoryFacade {

    @Autowired
    private UsersRepository repository;

    @Autowired
    private UsersBuilder usersBuilder;

    @Override
    public void salvar(UsersRequest usersRequest) {
        Users entity = usersBuilder.build(usersRequest);
       repository.save(entity);
    }

    @Override
    public UsersResponse validarSign(String password) {
        Users entity = repository.findByPassword(password);
        return usersBuilder.buildValidte(entity);
    }
}
