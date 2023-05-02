package com.example.queryDslExam.user_info.model;

import com.example.queryDslExam.user_info.entity.DummyComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DummyCommentsRepository extends JpaRepository<DummyComments, Long> {

}
