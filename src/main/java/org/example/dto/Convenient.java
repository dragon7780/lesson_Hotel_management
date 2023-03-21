package org.example.dto;

import lombok.*;
import org.example.entity.RoomEntity;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Setter
public class Convenient {
    private Integer id;
    private String convenient;
    private RoomEntity room;
}
