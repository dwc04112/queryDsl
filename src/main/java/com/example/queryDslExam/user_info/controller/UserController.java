package com.example.queryDslExam.user_info.controller;


import com.example.queryDslExam.common.api_response.ApiResponse;
import com.example.queryDslExam.user_info.DTO.UserInfoDTO;
import com.example.queryDslExam.user_info.entity.user_info;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user/info")
public class UserController {

    @GetMapping("/{id}")
    public ApiResponse<UserInfoDTO> createDummyUserInfo(@PathVariable Long id){
        user_info data = new user_info(id,"Test1", "A_CLASS", "SEOUL", 27);
        return ApiResponse.OK(UserInfoDTO.from(data));
    }

}
