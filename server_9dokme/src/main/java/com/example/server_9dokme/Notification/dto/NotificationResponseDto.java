package com.example.server_9dokme.Notification.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
public class NotificationResponseDto {

    private Long notificationId;
    private LocalDateTime startNotification;
    private Boolean isRead;
    private String message;
    private Long paramId;
    private String type;
}

