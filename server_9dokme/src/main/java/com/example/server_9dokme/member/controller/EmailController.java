package com.example.server_9dokme.member.controller;

import com.example.server_9dokme.member.dto.request.MailDto;
import com.example.server_9dokme.member.service.EmailService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/api")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @PostMapping("/mail")
    public String execMail(@RequestBody @Valid MailDto dto) {

        emailService.sendSimpleMessage(dto);
        return "전송 완료";
    }
}
