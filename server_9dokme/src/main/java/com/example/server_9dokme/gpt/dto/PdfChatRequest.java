package com.example.server_9dokme.gpt.dto;

import lombok.Data;

@Data
public class PdfChatRequest {
    private String url;
    private String question;
    private String bookName;
}
