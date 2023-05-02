package com.example.queryDslExam.user_info.controller;


import com.example.queryDslExam.common.api_response.ApiResponse;
import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import com.example.queryDslExam.user_info.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class DummyCommentsController {

    private final UserService userService;

    @GetMapping("/get")
    public ApiResponse<List<DummyCommentsDTO>> getDummyComments(){
        return ApiResponse.OK( userService.getDummyComments() );
    }

    @GetMapping("/set")
    public ApiResponse<String> setDummyComments(){
        return ApiResponse.OK( "insert " + userService.setDummyComments() + "data");
    }

}
