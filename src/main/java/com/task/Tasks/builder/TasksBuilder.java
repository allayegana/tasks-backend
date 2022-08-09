package com.task.Tasks.builder;

import com.task.Tasks.Response.TasksResponse;
import com.task.Tasks.entity.Tasks;
import com.task.Tasks.request.TasksRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
public class TasksBuilder {

    public Tasks build(TasksRequest tasksRequest) {

        return Tasks
                .builder()
                .descricao(tasksRequest.getDescricao())
                .estimateAt(LocalDateTime.parse(tasksRequest.getEstimateAt().toString()))
                .build();
    }


    public List<TasksResponse> listTasks(List<Tasks> tasks) {
        if (tasks == null){
            return new ArrayList<>();
        }

        return tasks.stream().map(TasksResponse::new).collect(Collectors.toList());
    }
}
