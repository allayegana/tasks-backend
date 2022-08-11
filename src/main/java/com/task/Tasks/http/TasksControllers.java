package com.task.Tasks.http;


import com.task.Tasks.Response.TasksResponse;
import com.task.Tasks.exception.ValideUsersNotFoundException;
import com.task.Tasks.request.TasksRequest;
import com.task.Tasks.useCase.TasksUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
@RequestMapping(path = "/tasks")
public class TasksControllers {


    @Autowired
    private TasksUseCase tasksUseCase;


    @GetMapping(path = "get-all", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<TasksResponse> getTasksList(){
        return tasksUseCase.getTasksList();
    }

//        @GetMapping(path = URLMapping.VIDANCE_API, produces = APPLICATION_JSON_VALUE)
//        @ResponseStatus(HttpStatus.OK)
//        public VidanceDto retourneLaClass(@PathVariable("id")Long id) {
//            return vidanceUseCase.retourneLaClass(id);
//        }

    @PostMapping(path = "cadastro", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void TasksSave(@Valid @RequestBody TasksRequest tasksRequest) {
        tasksUseCase.saveTasks(tasksRequest);
    }


    @PutMapping(path = "update/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void update(@Valid @PathVariable("id") Long id, @RequestBody TasksRequest request) throws ValideUsersNotFoundException {
        tasksUseCase.updateTasks(id, request);
    }

    @PutMapping(path = "done/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void doneAt(@Valid @PathVariable("id") Long id) throws ValideUsersNotFoundException {
        tasksUseCase.doneAt(id);
    }

    @DeleteMapping(path = "deletar/{id}", produces = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable("id") Long id) throws ValideUsersNotFoundException {
        tasksUseCase.deletar(id);
    }

}