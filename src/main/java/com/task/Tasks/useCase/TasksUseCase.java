package com.task.Tasks.useCase;

import com.task.Tasks.Repository.TasksRepository;
import com.task.Tasks.RepositoryFacade.TasksRepositoryFacade;
import com.task.Tasks.Response.TasksResponse;
import com.task.Tasks.exception.ValideUsersNotFoundException;
import com.task.Tasks.request.TasksRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class TasksUseCase {

    @Autowired
    private TasksRepositoryFacade tasksRepositoryFacade;

    @Autowired
    private TasksRepository repository;


    public void saveTasks(TasksRequest tasksRequest) {
        tasksRepositoryFacade.salvar(tasksRequest);
    }

    public List<TasksResponse> getTasksList() {
        return tasksRepositoryFacade.pegarListdoTasks();

    }

    public void updateTasks(Long id, TasksRequest request) throws ValideUsersNotFoundException {

        var tasks = repository.findById(id).orElseThrow(ValideUsersNotFoundException::new);
        tasks.setDescricao(request.getDescricao());
        tasks.setEstimateAt(request.getEstimateAt());
        repository.save(tasks);
    }

    public void doneAt(Long id) throws ValideUsersNotFoundException {

        var tasks = repository.findById(id).orElseThrow(ValideUsersNotFoundException::new);
        if (tasks.getDoneAt() == null) {
            tasks.setDoneAt(LocalDateTime.now());
        } else {
            tasks.setDoneAt(null);
        }
        repository.save(tasks);
    }

    public void deletar(Long id) throws ValideUsersNotFoundException {
        var tasks = repository.findById(id).orElseThrow(ValideUsersNotFoundException::new);
        repository.deleteById(tasks.getId());
    }
}
