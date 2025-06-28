package com.linlancai.manualtodoapp.controller;

import com.linlancai.manualtodoapp.dto.GetTodoResponseDto;
import com.linlancai.manualtodoapp.dto.ImmutableGetTodoResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
