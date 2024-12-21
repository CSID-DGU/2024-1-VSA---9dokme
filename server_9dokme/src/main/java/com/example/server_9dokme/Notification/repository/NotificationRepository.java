package com.example.server_9dokme.Notification.repository;

import com.example.server_9dokme.Notification.entity.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification,Integer> {

    Page<Notification> findAllByMember_MemberId(Long memberId, Pageable pageable);
}
