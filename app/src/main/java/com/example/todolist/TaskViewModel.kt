package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TaskViewModel(private val taskDao: TaskDao) : ViewModel() {
    val allTasks: LiveData<List<Task>> = taskDao.getAllTasks()

    fun insert(task: Task) {
        viewModelScope.launch {
            taskDao.insert(task)
        }
    }

    fun delete(task: Task) {
        viewModelScope.launch {
            taskDao.delete(task)
        }
    }
}