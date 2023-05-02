package com.example.queryDslExam;


import com.example.queryDslExam.user_info.entity.Quser_info;
import com.example.queryDslExam.user_info.entity.user_info;
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
            user_info user = user_info.builder()
                   .user_id(i)
                   .user_name("test")
                   .user_class("A_CLASS")
                   .region("SEOUL")
                   .age(27)
                   .build();
           em.persist(user);
        }
        em.flush();
    }

    @Test
    void query_dsl_select() {
        em = testEntityManager.getEntityManager();
        JPAQuery<user_info> query =  new JPAQuery<>(em);
        Quser_info qUser = new Quser_info("p");

        List<user_info> userList = query.from(qUser)
                .fetch();

        userList.forEach(System.out::println);

        Assertions.assertThat(userList.size()).isEqualTo(10);
    }
}
