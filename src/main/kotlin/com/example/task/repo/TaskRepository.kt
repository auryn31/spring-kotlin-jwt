package com.example.task.repo

import com.example.task.model.Task
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository : CrudRepository<Task, Long>