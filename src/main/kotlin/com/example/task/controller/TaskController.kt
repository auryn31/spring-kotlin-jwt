package com.example.task.controller

import com.example.task.model.Task
import com.example.task.repo.TaskRepository
import org.springframework.http.HttpEntity
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping(value = ["/api/task"])
class TaskController(val taskRepository: TaskRepository) {

    @GetMapping
    fun findAll(): HttpEntity<List<Task>> {
        return ResponseEntity(taskRepository.findAll().toList(), HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Long): HttpEntity<Task> {
        val task = taskRepository.findById(id)
        return if (task.isPresent) {
            ResponseEntity(task.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NO_CONTENT)
        }
    }

    @PostMapping("/add")
    fun add(@RequestBody task: Task): HttpEntity<Task> {
        val taskToReturn = taskRepository.save(task)
        return ResponseEntity(taskToReturn, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): HttpStatus {
        return if (taskRepository.existsById(id)) {
            taskRepository.deleteById(id)
            HttpStatus.OK
        } else {
            HttpStatus.NO_CONTENT
        }
    }
}