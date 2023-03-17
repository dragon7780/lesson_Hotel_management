package org.example.dto;

import lombok.*;
import org.example.enums.RoomType;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class Room {
    private Integer id;
    private Integer number;
    private Integer stage;
    private RoomType type;
    private Double price;
    private Integer area;
}
