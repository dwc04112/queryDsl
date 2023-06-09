package com.example.queryDslExam.user_info.service;

import com.example.queryDslExam.user_info.DTO.CmtWebClientResponseDTO;
import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import com.example.queryDslExam.user_info.entity.DummyComments;
import com.example.queryDslExam.user_info.model.CommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DummyCommentsService {

    private final CommentsRepository repository;
    WebClient webClient = WebClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build();

    public List<DummyComments> getDummyComments() {

        return webClient.get()
                .uri(uriBuilder ->
                        uriBuilder
                                .path("comments/")
                                .build()
                )
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .onStatus(HttpStatus::isError, ClientResponse::createException)
                .bodyToFlux(DummyComments.class)
                .onErrorResume(throwable -> {
                    return Mono.error(new RuntimeException("Parsing Error"));
                })
                .collectList().block();
    }
    public List<DummyComments> setDummyComments() {
        return repository.saveAll(getDummyComments());
    }


    public List<DummyComments> selectDummyComments() {
        return repository.searchAll();
    }
    public List<DummyComments> selectDummyCommentsByKeyword(String keyword) {
        return repository.searchByName(keyword);
    }



    public Long deleteDummyCommentsByKeyword(String keyword) {
        return repository.deleteByName(keyword);
    }
}
