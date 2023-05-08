package com.example.queryDslExam.user_info.controller;


import com.example.queryDslExam.common.api_response.ApiResponse;
import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import com.example.queryDslExam.user_info.entity.DummyComments;
import com.example.queryDslExam.user_info.service.DummyCommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class DummyCommentsController {

    private final DummyCommentsService dummyCommentsService;

    @GetMapping("/get")
    public ApiResponse<List<DummyCommentsDTO>> getDummyComments(){
        return ApiResponse.OK(dummyCommentsService.getDummyComments());
    }

    @GetMapping("/set")
    public ApiResponse<List<DummyCommentsDTO>> setDummyComments(){
        return ApiResponse.OK(
                dummyCommentsService.setDummyComments()
                .stream()
                .map(DummyCommentsDTO::from)
                .collect(Collectors.toList())
        );
    }


    @GetMapping("/select")
    public ApiResponse<List<DummyCommentsDTO>> selectDummyComments(){
        return ApiResponse.OK(
                dummyCommentsService.selectDummyComments()
                        .stream()
                        .map(DummyCommentsDTO::from)
                        .collect(Collectors.toList())
        );
    }
    @GetMapping("/select/{keyword}")
    public ApiResponse<Object> selectDummyCommentsByKeyword(@PathVariable String keyword){
        List<DummyCommentsDTO> result = dummyCommentsService.selectDummyCommentsByKeyword(keyword)
                .stream()
                .map(DummyCommentsDTO::from)
                .collect(Collectors.toList());
        return ApiResponse.OK_MSG(result, result.size());
    }
}
