package com.example.server_9dokme.member.repository;

import com.example.server_9dokme.member.entity.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, String> {

    @Query("SELECT d.deviceId " +
            "FROM Device d " +
            "JOIN d.member m " +
            "JOIN Keyword k ON k.member.memberId = m.memberId " +
            "WHERE k.keyword LIKE %:title%")
    List<String> findDeviceIdsByTitle(@Param("title") String title);
}
