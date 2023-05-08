package com.example.queryDslExam.user_info.model;

import com.example.queryDslExam.user_info.entity.DummyComments;

import java.util.List;

public interface CommentsRepositoryCustom {

    List<DummyComments> searchAll ();
    List<DummyComments> searchByName (String searchKeyword);
}
