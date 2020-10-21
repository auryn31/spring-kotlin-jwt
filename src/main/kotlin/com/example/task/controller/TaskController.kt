package com.example.task.controller

import com.example.task.model.Task
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping(value = ["/api/task"])
class TaskController {

    @GetMapping
    fun findAll(): HttpEntity<List<Task>> {
        return ResponseEntity(taskList(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): HttpEntity<Task> {
        val task = taskList().find { it.id == id }
        task?.let{
            return ResponseEntity(it, HttpStatus.OK)
        }
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    fun taskList(): List<Task> {
        return listOf(
                Task(0, "Buy Milk"),
                Task(1, "Buy Water"),
                Task(2, "Buy Eggs"),
                Task(3, "Buy Oil"),
                Task(4, "Buy Ice")
        )
    }
}