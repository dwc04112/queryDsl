package com.example.queryDslExam.user_info.model;

import com.example.queryDslExam.user_info.entity.DummyComments;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.queryDslExam.user_info.entity.QDummyComments.dummyComments;

@RequiredArgsConstructor
public class CommentsRepositoryImpl implements CommentsRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<DummyComments> searchAll() {
        return jpaQueryFactory
                .selectFrom(dummyComments)
                .fetch();
    }

    @Override
    public List<DummyComments> searchByName(String searchKeyword) {
        return jpaQueryFactory.select(dummyComments)
                .from(dummyComments)
                .where(dummyComments.name.contains(searchKeyword))
                .fetch();
    }
}

