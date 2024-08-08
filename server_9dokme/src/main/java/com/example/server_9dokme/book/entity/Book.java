package com.example.server_9dokme.book.entity;
import com.example.server_9dokme.common.entity.BaseEntity;
import com.example.server_9dokme.member.entity.Member;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private Long bookId;

//    @Column(name = "last_viewed_date")
//    private LocalDateTime lastViewedDate;

    private String title;

    private LocalDateTime publishDate; // 출판일자는 따로 기입해줘야하기 때문에 BaseEntity 사용 x

    private String author;

    private String publisher;

    private String category;

    private String bookImage;

    private String bookURL; // URL로 프론트에 넘겨주기로 했기 때문에 데이터타입 수정

    private Integer progress;

    private Integer rent;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
}
