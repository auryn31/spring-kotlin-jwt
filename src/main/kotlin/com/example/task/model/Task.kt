package com.example.task.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Task(
        val description: String = "",
        val done: Boolean = false,
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long = -1)