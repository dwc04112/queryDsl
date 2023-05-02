package com.example.queryDslExam.user_info.model;

import com.example.queryDslExam.user_info.entity.user_info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<user_info, Long> {

}
