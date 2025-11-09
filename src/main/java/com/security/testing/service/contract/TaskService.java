package com.security.testing.service.contract;

import com.security.testing.model.Task;
import java.util.List;

public interface TaskService {

    List<Task> getAll();

    Task getById(Long id);

    Task create(Task task);

    Task update(Task task);

    void delete(Long id);
}
