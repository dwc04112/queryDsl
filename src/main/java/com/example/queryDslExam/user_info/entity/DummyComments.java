package com.example.queryDslExam.user_info.entity;

import com.example.queryDslExam.user_info.DTO.DummyCommentsDTO;
import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "DummyComments")
@Entity
public class DummyComments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long postId;

    @Column(length = 1000)
    private String name;
    @Column(length = 1000)
    private String email;
    @Column(length = 2048)
    private String body;

    public static DummyComments toEntity(DummyCommentsDTO comments) {
        return DummyComments.builder()
                .id(comments.getId())
                .postId(comments.getPostId())
                .name(comments.getName())
                .email(comments.getEmail())
                .body(comments.getBody())
                .build();
    }
}
