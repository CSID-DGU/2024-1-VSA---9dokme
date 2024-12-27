package com.example.server_9dokme.gpt.repository;

import com.example.server_9dokme.gpt.entity.QnA;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QnARepository extends JpaRepository<QnA, Long> {
}
