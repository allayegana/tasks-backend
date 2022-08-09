package com.task.Tasks.RepositoryFacadeImpl;

import com.task.Tasks.Repository.TasksRepository;
import com.task.Tasks.RepositoryFacade.TasksRepositoryFacade;
import com.task.Tasks.Response.TasksResponse;
import com.task.Tasks.builder.TasksBuilder;
import com.task.Tasks.entity.Tasks;
import com.task.Tasks.request.TasksRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TasksRepositoryImpl implements TasksRepositoryFacade {

    @Autowired
    private TasksRepository repository;

    @Autowired
    private TasksBuilder tasksBuilder;

    @Override
    public void salvar(TasksRequest tasksRequest) {
        Tasks entity = tasksBuilder.build(tasksRequest);
       repository.save(entity);
    }

    @Override
    public List<TasksResponse> pegarListdoTasks() {
        var tasks = repository.findAll();
        return tasksBuilder.listTasks(tasks);
    }

}
