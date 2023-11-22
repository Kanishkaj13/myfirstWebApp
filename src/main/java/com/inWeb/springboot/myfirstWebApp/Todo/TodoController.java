package com.inWeb.springboot.myfirstWebApp.Todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {


    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    private TodoService todoService;


    @RequestMapping("list-todos")
    public String listAllTodos(ModelMap model) {
        List<Todo> todos = todoService.findByUsername("in28minutes");
        model.addAttribute("todos", todos);

        return "listTodos";
    }

    @RequestMapping(value = "add-todo", method = RequestMethod.GET)
    public String ShowNewTodoPage(ModelMap model) {
        String username;
        Todo todo =new Todo(0,username, "", LocalDate.now().plusYears(1), false);
        model.put("todo", todo);
        return "todo";
    }


        @RequestMapping(value = "add-todo", method = RequestMethod.POST)
       
        public String addNewTodo (ModelMap model, @Valid Todo todo, BindingResult result) {

            if (result.hasErrors()) {
                return "todo";
            }
            String username = (String) model.get("name");
            todoService.addTodo(username, todo.getDescription(),
                    todo.getTargetDate(), false);
            return "redirect:List-todos";
        }

        @RequestMapping("delete-todos")
        public String deleteTodo ( @RequestParam int id){


            return "redirect:list-todos";

        }

        @RequestMapping("update-todo")
        public String showUpdateTodoPage ( @RequestParam int id){

            return "redirect:list-todos";
        }
    }

