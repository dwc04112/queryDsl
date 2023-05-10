package com.example.queryDslExam.user_info.controller;


import com.example.queryDslExam.common.api_response.ApiResponse;
import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import com.example.queryDslExam.user_info.entity.DummyComments;
import com.example.queryDslExam.user_info.service.DummyCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class DummyCommentsController {

    private final DummyCommentsService dummyCommentsService;

    @GetMapping("/set")
    public ApiResponse<List<DummyCommentsDTO>> setDummyComments() {
        return ApiResponse.OK(
                dummyCommentsService.setDummyComments()
                .stream()
                .map(DummyCommentsDTO::from)
                .collect(Collectors.toList())
        );
    }


    @GetMapping("/select")
    public List<DummyCommentsDTO> selectDummyComments(){
        return
                dummyCommentsService.selectDummyComments()
                        .stream()
                        .map(DummyCommentsDTO::from)
                        .collect(Collectors.toList());
    }
    @GetMapping("/select/{keyword}")
    public List<DummyCommentsDTO> selectDummyCommentsByKeyword(@PathVariable String keyword){
        return dummyCommentsService.selectDummyCommentsByKeyword(keyword).stream()
                .map(DummyCommentsDTO::from)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{keyword}")
    public ApiResponse<Object> deleteDummyCommentsByKeyword(@PathVariable String keyword){
        return ApiResponse.OK_MSG(null, dummyCommentsService.deleteDummyCommentsByKeyword(keyword));
    }


}
