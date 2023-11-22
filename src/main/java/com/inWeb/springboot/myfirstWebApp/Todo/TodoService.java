package com.inWeb.springboot.myfirstWebApp.Todo;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Service
@SessionAttributes("name")
public class TodoService {
    private static List<Todo> todos = new ArrayList<>();
    private static int todosCount = 0;

    static {
        int todoscount = 0;
        todos.add(new Todo(++todoscount, "in28minutes", "Learn AWS",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoscount, "in28minutes", "Learn DevOps",
                LocalDate.now().plusYears(1), false));
        todos.add(new Todo(++todoscount, "in28minutes", "Learn Full Stack Development",
                LocalDate.now().plusYears(1), false));
    }

    public List<Todo> findByUsername(String username) {
        return todos;
    }

    public void addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(++todosCount, username, description, targetDate, done);
        todos.add(todo);
    }

    public void deleteById(int id) {

        Predicate<? super Todo> predicate = todo -> todo.getId() = id;
        todos.removeIf(predicate);
    }

}

