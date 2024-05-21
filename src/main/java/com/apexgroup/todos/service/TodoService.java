package com.apexgroup.todos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import com.apexgroup.todos.persistance.model.Todo;
import com.apexgroup.todos.persistance.repository.TodoRepository;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll() {
        return todoRepository.findAll(Sort.by(Sort.Direction.ASC, "duedate"));
    }

    public Todo findById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Todo not found [id: %d]", id)));
    }

    public long create(String description, String duedate) {
        Todo todo = Todo.Create(description);
        todo.setDuedate(duedate);

        return todoRepository.save(todo).getId();
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
