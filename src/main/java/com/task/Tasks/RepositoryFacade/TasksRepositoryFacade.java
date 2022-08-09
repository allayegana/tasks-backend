package com.task.Tasks.RepositoryFacade;

import com.task.Tasks.Response.TasksResponse;
import com.task.Tasks.request.TasksRequest;

import java.util.List;

public interface TasksRepositoryFacade {

    void salvar(TasksRequest tasksRequest);

    List<TasksResponse> pegarListdoTasks();

}
