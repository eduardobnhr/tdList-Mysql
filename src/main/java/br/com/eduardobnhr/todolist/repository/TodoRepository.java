package br.com.eduardobnhr.todolist.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eduardobnhr.todolist.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
