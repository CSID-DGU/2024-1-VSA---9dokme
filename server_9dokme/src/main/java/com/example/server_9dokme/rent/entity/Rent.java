package com.example.server_9dokme.rent.entity;

import com.example.server_9dokme.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//pdf 웹 뷰 조회시 갱신되는 엔티티
@Entity
@Getter
@NoArgsConstructor
public class Rent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rent_id")
    private Long rentId;

    private LocalDateTime rentDate;

    private LocalDateTime returnDate;

    //최근 본 순으로 정렬
    private LocalDateTime readAt;

    private Long progress;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "subscribe_id")
    private Long subscribeId;

    @Column(name = "book_id")
    private Long bookId;
}
