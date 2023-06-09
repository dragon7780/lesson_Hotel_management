package org.example.entity;

import lombok.*;

import javax.persistence.*;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
@Entity
@Table(name = "convenient")
public class ConvenientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String convenient;
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "room_id")
//    private RoomEntity room;
}
