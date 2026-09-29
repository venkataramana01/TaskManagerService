package com.venkataramana.taskservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.venkataramana.taskservice.dto.TaskRequest;
import com.venkataramana.taskservice.entity.Task;
import com.venkataramana.taskservice.repository.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository taskRepository;
	public TaskService(TaskRepository taskRepository) {
		this.taskRepository=taskRepository;
	}
	public Task createTask(TaskRequest request) {

	    Task task = new Task();

	    task.setTitle(request.getTitle());
	    task.setDescription(request.getDescription());
	    task.setStatus(request.getStatus());
	    task.setPriority(request.getPriority());

	    return taskRepository.save(task);
	}
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	public Task getTaskById(long id) {
		return taskRepository.findById(id).orElse(null);
	}
	public Task updateTask(long id,Task task) {
		Task existingTask = taskRepository.findById(id).orElse(null);

        if (existingTask == null) {
            return null;
        }

        existingTask.setTitle(task.getTitle());
        existingTask.setDescription(task.getDescription());
        existingTask.setStatus(task.getStatus());
        existingTask.setPriority(task.getPriority());

        return taskRepository.save(existingTask);
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }

	}
