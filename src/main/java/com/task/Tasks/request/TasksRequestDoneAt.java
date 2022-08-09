package com.task.Tasks.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;


@AllArgsConstructor
@Builder
@Data
public class TasksRequestDoneAt {

    @NotNull
    @JsonProperty("doneAt")
    private LocalDateTime doneAt;

}


