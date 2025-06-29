package com.linlancai.manualtodoapp.controller;

import com.linlancai.manualtodoapp.dto.GetTodoResponseDto;
import com.linlancai.manualtodoapp.dto.ImmutableGetTodoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

@RestController
public class TodoController {
    @GetMapping("/todos")
    public ResponseEntity<List<GetTodoResponseDto>> getAllTodos() {
        GetTodoResponseDto todoItem01 = ImmutableGetTodoResponseDto
                .builder()
                .id("01")
                .title("Simple Todo 01")
                .content("This is a simple todo item.")
                .createAt(System.currentTimeMillis())
                .build();
        GetTodoResponseDto todoItem02 = ImmutableGetTodoResponseDto
                .builder()
                .id("02")
                .title("Simple Todo 02")
                .content("This is another simple todo item.")
                .createAt(System.currentTimeMillis())
                .build();

        return ResponseEntity.ok(List.of(todoItem01, todoItem02));
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveTodo() {
        // This is a placeholder for the save operation.
        // In a real application, you would handle the request body and save the todo item to a database.
        return ResponseEntity.ok("Todo item saved successfully.");
    }

    @GetMapping("/search")
    public ResponseEntity<String> search() {
        // This is a placeholder for the search operation.
        // In a real application, you would handle the search query and return relevant todo items.
        return ResponseEntity.ok("Search functionality is not implemented yet.");
    }
    @GetMapping("edit/{id}")
    public ResponseEntity<String> editTodo(String id) {
        // This is a placeholder for the edit operation.
        // In a real application, you would retrieve the todo item by ID and return it for editing.
        return ResponseEntity.ok("Edit functionality is not implemented yet for ID: " + id);
    }
    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteTodo(String id) {
        // This is a placeholder for the delete operation.
        // In a real application, you would delete the todo item by ID and return a success message.
        return ResponseEntity.ok("Delete functionality is not implemented yet for ID: " + id);
    }

}
