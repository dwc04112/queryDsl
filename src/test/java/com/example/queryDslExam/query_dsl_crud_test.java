package com.example.queryDslExam;


import com.example.queryDslExam.user_info.entity.DummyComments;
import com.example.queryDslExam.user_info.entity.Quser_info;
import com.querydsl.jpa.impl.JPAQuery;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import javax.persistence.EntityManager;
import java.util.List;

@DataJpaTest
public class query_dsl_crud_test {

    @Autowired
    TestEntityManager testEntityManager;
    EntityManager em;



    @BeforeEach
    void insert_data() {
        em = testEntityManager.getEntityManager();

        for (long i = 0; i < 10; i++) {
            DummyComments user = DummyComments.builder()
                   .id(i)
                   .postId(i)
                   .name("A_CLASS")
                   .email("SEOUL")
                   .build();
           em.persist(user);
        }
        em.flush();
    }

    @Test
    void query_dsl_select() {
        em = testEntityManager.getEntityManager();
        JPAQuery<DummyComments> query =  new JPAQuery<>(em);
        Quser_info qUser = new Quser_info("p");

        List<DummyComments> userList = query.from(qUser)
                .fetch();

        userList.forEach(System.out::println);

        Assertions.assertThat(userList.size()).isEqualTo(10);
    }
}
