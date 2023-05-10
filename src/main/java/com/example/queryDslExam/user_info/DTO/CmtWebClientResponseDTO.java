package com.example.queryDslExam.user_info.DTO;

import com.example.queryDslExam.user_info.entity.DummyComments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CmtWebClientResponseDTO {
    private List<DummyCommentsDTO> content;

}
