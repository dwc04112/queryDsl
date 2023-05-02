package com.example.queryDslExam.user_info.service;

import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import com.example.queryDslExam.user_info.entity.DummyComments;
import com.example.queryDslExam.user_info.model.DummyCommentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final DummyCommentsRepository repository;
    WebClient webClient = WebClient.builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .build();

    public List<DummyCommentsDTO> getDummyComments() {
        return webClient.get()
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
    }

    public Integer setDummyComments() {
        List<DummyComments> data = getDummyComments()
                .stream()
                .map(DummyComments::toEntity)
                .collect(Collectors.toList());
        return repository.saveAll(data).size();
    }
}
