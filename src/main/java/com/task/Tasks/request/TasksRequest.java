package com.task.Tasks.request;

import com.task.Tasks.entity.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@AllArgsConstructor
@Builder
@Data
public class TasksRequest {

    @NotNull
    private String descricao;
    @NotNull
    private LocalDateTime estimateAt;

}


