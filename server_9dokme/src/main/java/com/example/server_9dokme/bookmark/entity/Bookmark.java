package com.example.server_9dokme.bookmark.entity;

import com.example.server_9dokme.book.entity.Book;
import com.example.server_9dokme.common.entity.BaseEntity;
import com.example.server_9dokme.member.entity.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Entity
@Slf4j
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Bookmark extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookmark_id")
    private Long bookmarkId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @Builder
    public Bookmark(Long bookmarkId, Member member, Book book){
        this.bookmarkId = bookmarkId;
        this.member = member;
        this.book = book;
    }

    public Bookmark(Member member, Book book) {
        this.member = member;
        this.book = book;
    }
}
