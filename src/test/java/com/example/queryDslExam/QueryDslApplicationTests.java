package com.example.queryDslExam;

import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@SpringBootTest
class QueryDslApplicationTests {


	@Test
	void contextLoads() {
		WebClient webClient = WebClient.builder()
				.baseUrl("https://jsonplaceholder.typicode.com/")
				.build();

		List<DummyCommentsDTO> resp = webClient.get()
				.uri(uriBuilder ->
						uriBuilder
								.path("comments/")
								.build()
				)
				.accept(MediaType.APPLICATION_JSON)
				.retrieve()
				.onStatus(HttpStatus::isError, ClientResponse::createException)
				.bodyToFlux(DummyCommentsDTO.class)
				.collectList()
				.block();

		System.out.println(resp.size());
	}

}
