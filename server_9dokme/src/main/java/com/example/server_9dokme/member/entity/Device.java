package com.example.server_9dokme.member.entity;


import com.example.server_9dokme.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
public class Device extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String deviceId;

    private Boolean notificationStatement;

    private String userFirebaseToken;

    @ManyToOne
    @JoinColumn(name ="member_id")
    private Member member;
}
