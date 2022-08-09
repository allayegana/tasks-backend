package com.task.Tasks.Response;


import com.task.Tasks.entity.Tasks;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
public class TasksResponse {

    private String descricao;
    private LocalDateTime estimateAt;
    private LocalDateTime doneAt;

    public TasksResponse(Tasks tasks) {
      this.descricao = tasks.getDescricao();
      this.estimateAt = tasks.getEstimateAt();
      this.doneAt = tasks.getDoneAt();
    }
}
