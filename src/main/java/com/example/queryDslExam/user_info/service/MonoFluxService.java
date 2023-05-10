package com.example.queryDslExam.user_info.service;

import com.example.queryDslExam.user_info.DTO.CmtWebClientResponseDTO;
import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import com.example.queryDslExam.user_info.entity.DummyComments;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonoFluxService {

    WebClient webClient = WebClient.builder()
            .baseUrl("http://localhost:8080/")
            .build();

    public Flux<DummyCommentsDTO> getDummyComments() {

        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("comments/select/mo")
                                .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::isError, ClientResponse::createException)
                .bodyToFlux(DummyCommentsDTO.class)
                .onErrorResume(throwable -> {
                    return Mono.error(new RuntimeException("Parsing Error"));
                });
    }
}
