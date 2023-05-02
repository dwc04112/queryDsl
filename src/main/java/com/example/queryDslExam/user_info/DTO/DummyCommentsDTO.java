package com.example.queryDslExam.user_info.DTO;

import com.example.queryDslExam.user_info.entity.DummyComments;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DummyCommentsDTO {

    private Long id;

    private Long postId;
    private String name;
    private String email;
    private String body;

    public static DummyCommentsDTO from(DummyComments comments) {
        return DummyCommentsDTO.builder()
                .id(comments.getId())
                .postId(comments.getPostId())
                .name(comments.getName())
                .email(comments.getEmail())
                .body(comments.getBody())
                .build();
    }


}
