package com.example.server_9dokme.book.service;

import com.example.server_9dokme.book.dto.request.BookCreateRequest;
import com.example.server_9dokme.book.dto.request.BookUpdateRequest;
import com.example.server_9dokme.book.dto.response.BookInfoResponse;
import com.example.server_9dokme.book.dto.response.MyPageDto;
import com.example.server_9dokme.book.dto.response.ProfileDto;
import com.example.server_9dokme.bookmark.repository.BookmarkRepository;
import com.example.server_9dokme.member.entity.Member;
import com.example.server_9dokme.member.repository.KeywordRepository;
import com.example.server_9dokme.member.repository.MemberRepository;
import com.example.server_9dokme.book.dto.response.BookCheckDto;
import com.example.server_9dokme.book.dto.response.BookWebViewDto;
import com.example.server_9dokme.book.entity.Book;
import com.example.server_9dokme.book.exception.BookException;
import com.example.server_9dokme.book.message.ErrorMessage;
import com.example.server_9dokme.book.repository.BookRepository;
import com.example.server_9dokme.member.dto.response.BookDto;
import com.example.server_9dokme.rent.entity.Rent;
import com.example.server_9dokme.rent.repository.RentRepository;
import com.example.server_9dokme.subscribe.repository.SubscribeRepository;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Data
@NoArgsConstructor
@Slf4j
public class BookService {

    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private RentRepository rentRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private BookmarkRepository bookmarkRepository;
    @Autowired
    private SubscribeRepository subscribeRepository;
    @Autowired
    private KeywordRepository keywordRepository;

    public BookCheckDto checkBook(Long bookId,Long memberId){

        Book book = bookRepository.findByBookId(bookId);
        int lastPage;
        if(rentRepository.existsByBookIdAndMemberId(bookId,memberId)){
            lastPage = rentRepository.findByBookIdAndMemberId(bookId,memberId).getLastPage();
        } else {
            lastPage = 1;
        }

        BookCheckDto dto = BookCheckDto.builder().
                bookId(book.getBookId()).
                title(book.getTitle()).
                author(book.getAuthor()).
                description(book.getDescription()).
                publisher(book.getPublisher()).
                category(book.getCategory()).
                pdfImage(book.getBookImage()).
                lastPage(lastPage).
                category(book.getCategory()).
                isMarked(bookmarkRepository.existsBookmarkByBook_BookIdAndMember_MemberId(book.getBookId(),memberId)).build();
            return dto;
    }

    public Page<BookDto> searchBook(String title, int pageNo, Long memberId){

        Member member = memberRepository.findByMemberId(memberId);

        Pageable pageable = PageRequest.of(pageNo,4);
        Page<Book> bookPage;

        if(title.equals("")){
            bookPage = bookRepository.findAll(pageable);
        }else{
            bookPage = bookRepository.findByTitleContaining(title, pageable);
        }

        Page<BookDto> bookDtoPage = bookPage.map(book -> new BookDto(
                book.getBookId(),
                book.getTitle(),
                book.getCategory(),
                book.getBookURL(),
                book.getBookImage(),
                bookmarkRepository.existsBookmarkByBook_BookIdAndMember_MemberId(book.getBookId(),member.getMemberId())));



        return bookDtoPage;
    }


    public BookWebViewDto bookWebView(Long bookId){
        Book book = bookRepository.findByBookId(bookId);


        return BookWebViewDto.builder().
                title(book.getTitle()).
                category(book.getCategory()).
                author(book.getAuthor()).
                pdfUrl(book.getBookURL()).
                build();
    }


    public void saveRentBook(Long bookId, String socialId){


        Member member = memberRepository.findBySocialId(socialId);


        if(!rentRepository.existsByBookIdAndMemberId(bookId,member.getMemberId())){
            Rent initRent = new Rent();
            initRent.setBookId(bookId);
            initRent.setProgress(Float.valueOf(0L));
            initRent.setLastPage(0);
            initRent.setRentDate(LocalDateTime.now(ZoneId.of("Asia/Seoul")));
            initRent.setMemberId(member.getMemberId());
            initRent.setReadAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")));

            rentRepository.save(initRent);
        }else{
            Rent updateRent = rentRepository.findByBookIdAndMemberId(bookId, member.getMemberId());
            updateRent.setReadAt(LocalDateTime.now(ZoneId.of("Asia/Seoul")));

            rentRepository.save(updateRent);
        }

    }

    public void updateProgress(Long bookId, Long memberId, int lastPage){

        Book book = bookRepository.findByBookId(bookId);

        Rent updateRent = rentRepository.findByBookIdAndMemberId(bookId,memberId);

        int fullPage = book.getBookFullPage();

        float progress = ((float)lastPage /fullPage) * 100;

        updateRent.setProgress(progress);
        updateRent.setLastPage(lastPage);

        rentRepository.save(updateRent);
    }

    public Optional<Book> findById(Long bookId) {
        return bookRepository.findById(bookId);
    }

    @Transactional
    public BookInfoResponse createBook(BookCreateRequest request) {
        Book book = Book.create(
                request.title(),
                request.publishDate(),
                request.author(),
                request.publisher(),
                request.category(),
                request.description(),
                request.bookImage(),
                request.bookURL(),
                request.bookChapter(),
                request.bookFullPage(),
                request.rent()
        );
        bookRepository.save(book);
        return toResponse(book);
    }

    @Transactional
    public BookInfoResponse updateBook(Long bookId, BookUpdateRequest request) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookException(ErrorMessage.NOT_FOUND_BOOK));

        book.update(
                request.title(),
                request.publishDate(),
                request.author(),
                request.publisher(),
                request.category(),
                request.description(),
                request.bookImage(),
                request.bookURL(),
                request.bookChapter(),
                request.bookFullPage(),
                request.rent()
        );

        bookRepository.save(book);
        return toResponse(book);
    }

    @Transactional
    public void deleteBook(Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new BookException(ErrorMessage.NOT_FOUND_BOOK));
        bookRepository.delete(book);
    }

    private BookInfoResponse toResponse(Book book) {
        return new BookInfoResponse(
                book.getBookId(),
                book.getTitle(),
                book.getPublishDate(),
                book.getAuthor(),
                book.getPublisher(),
                book.getCategory(),
                book.getDescription(),
                book.getBookImage(),
                book.getBookURL(),
                book.getBookChapter(),
                book.getBookFullPage(),
                book.getRent()
        );
    }


//    public MyPageDto getMypageBookList(Long memberId, int pageNo) {
//        Pageable pageable = PageRequest.of(pageNo, 8); // 페이지 번호와 크기 설정
//
//        // 회원 조회
//        Member member = memberRepository.findByMemberId(memberId);
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//
//        // 프로필 정보 생성
//        ProfileDto profileDto = new ProfileDto(
//                member.getMemberId(),
//                member.getNickName(),
//                member.getSubscribe().getExpiredAt().format(formatter)
//        );
//
//        // 북마크된 책들 페이지 처리하여 가져오기
//        Page<Book> page = bookRepository.findBooksByMember(memberId, pageable);
//
//        // BookDto로 변환
//        Page<BookDto> bookDtoPage = page.map(book -> new BookDto(
//                book.getBookId(),
//                book.getTitle(),
//                book.getCategory(),
//                book.getBookURL(),
//                book.getBookImage(),
//                bookmarkRepository.existsBookmarkByBook_BookIdAndMember_MemberId(book.getBookId(), memberId)));
//
//        // MyPageDto 반환
//        return new MyPageDto(profileDto, bookDtoPage);
//    }

    public MyPageDto getMypageBookList(Long memberId, int pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 8); // 페이지 번호와 크기 설정

        // 회원 조회
        Member member = memberRepository.findByMemberId(memberId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // 구독 여부 확인 및 프로필 정보 생성
        boolean isSubscribed = member.getSubscribe() != null;
        String expirationDate = isSubscribed ? member.getSubscribe().getExpiredAt().format(formatter) : null;

        ProfileDto profileDto = new ProfileDto(
                member.getMemberId(),
                member.getNickName(),
                expirationDate,
                isSubscribed
        );

        // 북마크된 책들 페이지 처리하여 가져오기
        Page<Book> page = bookRepository.findBooksByMember(memberId, pageable);

        // BookDto로 변환
        Page<BookDto> bookDtoPage = page.map(book -> new BookDto(
                book.getBookId(),
                book.getTitle(),
                book.getCategory(),
                book.getBookURL(),
                book.getBookImage(),
                bookmarkRepository.existsBookmarkByBook_BookIdAndMember_MemberId(book.getBookId(), memberId)));

        // MyPageDto 반환
        return new MyPageDto(profileDto, bookDtoPage);
    }


}
