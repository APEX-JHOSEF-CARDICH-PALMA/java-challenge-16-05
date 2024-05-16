package com.apexgroup.todos.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apexgroup.todos.persistance.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
