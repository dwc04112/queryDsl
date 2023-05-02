package com.example.queryDslExam.user_info.DTO;

import com.example.queryDslExam.user_info.entity.user_info;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
public class UserInfoDTO {

    private Long user_id;
    private String user_name;
    private String user_class;
    private String region;
    private int age;

    public static UserInfoDTO from(user_info userInfo) {
        return UserInfoDTO.builder()
                .user_id(userInfo.getUser_id())
                .user_name(userInfo.getUser_name())
                .user_class(userInfo.getUser_class())
                .region(userInfo.getRegion())
                .age(userInfo.getAge())
                .build();
    }
}
