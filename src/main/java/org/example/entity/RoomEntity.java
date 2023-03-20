package org.example.entity;

import org.example.enums.RoomType;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private Integer stage;
    @Enumerated(value = EnumType.STRING)
    private RoomType type;
    private Double price;
    private Integer area;
}
