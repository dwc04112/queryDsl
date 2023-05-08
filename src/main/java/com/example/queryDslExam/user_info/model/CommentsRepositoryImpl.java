package com.example.queryDslExam.user_info.model;

import com.example.queryDslExam.user_info.entity.DummyComments;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    @Modifying
    public Long deleteByName(String searchKeyword) {
        return jpaQueryFactory.delete(dummyComments)
                .where(dummyComments.name.contains(searchKeyword))
                .execute();
    }
}

