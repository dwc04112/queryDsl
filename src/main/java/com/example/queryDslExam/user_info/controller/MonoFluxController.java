package com.example.queryDslExam.user_info.controller;

import com.example.queryDslExam.common.api_response.ApiResponse;
import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import com.example.queryDslExam.user_info.service.MonoFluxService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/mono")
public class MonoFluxController {

    private final MonoFluxService monoFluxService;

    @GetMapping("/select")
    public Mono<ApiResponse<Object>> setDummyComments() {
        return monoFluxService.getDummyComments()
                .collectList()
                .map(res -> ApiResponse.OK_MSG(res, res.size()));
    }
}
