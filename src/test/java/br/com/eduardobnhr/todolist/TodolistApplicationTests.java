package br.com.eduardobnhr.todolist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.eduardobnhr.todolist.entity.Todo;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class TodolistApplicationTests {
	@Autowired
	private WebTestClient webTestClient;
	
	@Test
	void testCreateTodoSucess() {
		var todo = new Todo("todo 1", "desc todo 1", false, 1);

		webTestClient
		.post()
		.uri("/todos")
		.bodyValue(todo)
		.exchange()
		.expectStatus().isOk()
		.expectBody()
		.jsonPath("$").isArray()
		.jsonPath("$.length()").isEqualTo(1)
		.jsonPath("$[0].nome").isEqualTo(todo.getNome())
		.jsonPath("$[0].nome").isEqualTo(todo.getDescricao())
		.jsonPath("$[0].nome").isEqualTo(todo.isRealizado())
		.jsonPath("$[0].nome").isEqualTo(todo.getPrioridade());
		

	}
	@Test
	void testCreateTodoFailure() {
		webTestClient
		.post()
		.uri("/todos")
		.bodyValue(
			new Todo(nome:"", descricao:"", realizado:false, prioridade: 0))
		.exchange().expectStatus().isBadRequest();

	}

}
