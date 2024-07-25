package com.example.task.Controller;


import com.example.task.Api.ApiResponse;
import com.example.task.Model.Task;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/task")
public class TaskController {

    ArrayList<Task> tasks = new ArrayList<>();

    @GetMapping("/get")
    public ArrayList<Task> displayTasks() {
        return tasks;
    }

    @PostMapping("/post")
    public ApiResponse addTask(@RequestBody Task task) {
        tasks.add(task);
        return new ApiResponse ("task added","200") ;
    }

    @PutMapping("/update/{index}")
    public ApiResponse updateTask(@PathVariable int index , @RequestBody Task task) {
        tasks.set(index, task);
        return new ApiResponse("task updated","200");
    }

    @DeleteMapping("/delete/{index}")
    public ApiResponse deleteTask(@PathVariable int index ) {
        tasks.remove(index);
        return new ApiResponse("task deleted","200");
    }

    @PutMapping("/changestatus/{index}")
    public ApiResponse changeStatus(@PathVariable int index) {
        if(tasks.get(index).getStatus().equals("not done")){
            System.out.println("not done");
            tasks.get(index).setStatus("done");
        }
        return new ApiResponse("task statud updated","200");
    }

    @GetMapping("/search/{title}")
    public Task searchTask(@PathVariable String title) {
        for (Task task : tasks) {
            if (task.getTitle().equals(title)) {
                return task;
            }
        }
        return null;
    }





}
