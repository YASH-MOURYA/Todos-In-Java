package com.yash.project1.springboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer>{
	
	public List<Todo> findByUsernameIgnoreCase(String username);
}


