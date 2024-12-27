package com.example.server_9dokme.gpt.entity;

import com.example.server_9dokme.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class QnA extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "qna_id")
    private Long qnaId;

    private String bookName;

    @Column(columnDefinition = "TEXT")
    private String url;

    @Column(columnDefinition = "TEXT")
    private String question;

    @Column(columnDefinition = "TEXT")
    private String answer;
}
