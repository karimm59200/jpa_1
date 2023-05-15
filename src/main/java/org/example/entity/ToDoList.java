package org.example.entity;
import javax.persistence.*;

@Entity

@Table( name = "todolist")
public class ToDoList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "task")
    private String task;

    @Column(name = "status")
    private boolean status;

    public ToDoList(Long id, String task, boolean status) {
        this.id = id;
        this.task = task;
        this.status = status;
    }

    public ToDoList(String task, boolean status) {
        this.task = task;
        this.status = status;
    }

    public ToDoList() {

    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ToDoList{" +
                "id=" + id +
                ", task='" + task + '\'' +
                ", status=" + status +
                '}';
    }
}
