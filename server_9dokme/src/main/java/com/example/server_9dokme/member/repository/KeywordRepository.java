package com.example.server_9dokme.member.repository;

import com.example.server_9dokme.member.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword,Integer> {

    List<Keyword> findAllByKeywordContaining(String keyword);
}
