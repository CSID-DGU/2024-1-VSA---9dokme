package com.example.server_9dokme.book.dto.request;

import org.springframework.web.multipart.MultipartFile;

public record BarcodeRequest(
        MultipartFile image
) {
}
