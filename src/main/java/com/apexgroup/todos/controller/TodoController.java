package com.apexgroup.todos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.apexgroup.todos.service.TodoService;

@Controller
public class TodoController {
    @Autowired
    private TodoService todoService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("todos", todoService.findAll());
        return "index";
    }

    @PostMapping("todo")
    public String create(@RequestParam String description) {
        todoService.create(description);
        return "redirect:/";
    }

    @PostMapping("todo/delete")
    public String delete(@RequestParam Long id) {
        todoService.delete(id);
        return "redirect:/";
    }
}
