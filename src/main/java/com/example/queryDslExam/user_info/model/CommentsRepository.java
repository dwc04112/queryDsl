package com.example.queryDslExam.user_info.model;

import com.example.queryDslExam.user_info.entity.DummyComments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsRepository extends JpaRepository<DummyComments, Long>,
        CommentsRepositoryCustom  {
    List<DummyComments> searchAll ();
    List<DummyComments> searchByName (String searchKeyword);

    Long deleteByName(String searchKeyword);
}
