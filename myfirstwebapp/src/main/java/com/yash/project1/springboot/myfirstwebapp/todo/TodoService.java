package com.yash.project1.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import ch.qos.logback.core.filter.Filter;
import jakarta.validation.Valid;
@Service
public class TodoService {
	private static List<Todo> todos= new ArrayList<>();
	private static int todoCount=0;
	static {
		todos.add(new Todo(++todoCount, "yash", "Learn AWS1", LocalDate.now().plusYears(1), false));

		todos.add(new Todo(++todoCount, "yash", "Learn Azure2", LocalDate.now().plusYears(2), false));

		todos.add(new Todo(++todoCount, "yash", "Learn DevOps3", LocalDate.now().plusYears(3), false));
	}

	public List<Todo> findByUsername(String username) {
		Predicate<? super Todo> Predicate = todo ->todo.getUsername().equalsIgnoreCase(username);
		return todos.stream().filter(Predicate).toList();
	}
	public void addTodo(String username, String description,
			LocalDate targetDate, boolean done){
		Todo todo = new Todo(++todoCount, username, description, targetDate, done);
		todos.add(todo);
	}
	public void deleteTodoById(int id) {
		Predicate<? super Todo> Predicate = todo ->todo.getId()==id;
		
		todos.removeIf(Predicate);
	}
	public Todo findById(int id) {
		// TODO Auto-generated method stub
Predicate<? super Todo> Predicate = todo ->todo.getId()==id;
		
		Todo todo = todos.stream().filter(Predicate).findFirst().get();
		return todo;
	}
	public void updateTodo(@Valid Todo todo) {
		// TODO Auto-generated method stub
		deleteTodoById(todo.getId());
		todos.add(todo);
		
	}
}
