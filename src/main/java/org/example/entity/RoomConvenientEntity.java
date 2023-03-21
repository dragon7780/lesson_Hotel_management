package org.example.entity;

import javax.persistence.*;
@Entity
@Table(name = "room_convenient")
public class RoomConvenientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String convenient;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "room_id")
    private RoomEntity room;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "convenient_id")
    private ConvenientEntity convenient_id;
}
