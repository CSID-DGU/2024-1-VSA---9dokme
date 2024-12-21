package com.example.server_9dokme.Notification.controller;


import com.example.server_9dokme.Notification.dto.NotificationResponseDto;
import com.example.server_9dokme.Notification.service.NotificationService;
import com.example.server_9dokme.common.FindLoginMember;
import com.example.server_9dokme.member.dto.response.PostWrittenDto;
import com.example.server_9dokme.member.repository.MemberRepository;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("/notification")
    @Operation(summary = "알림 리스트", description = "알림 리스트")
    public ResponseEntity<Page<NotificationResponseDto>> getNotifications(@RequestParam(required = false, defaultValue = "0", value = "page") int pageNo) {

        String memberEmail = FindLoginMember.getCurrentUserId();

        Long memberId = memberRepository.findBySocialId(memberEmail).getMemberId();


        Page<NotificationResponseDto> notificationList = notificationService.findAllNotification(memberId,pageNo);

        return ResponseEntity.ok(notificationList);


    }
}
