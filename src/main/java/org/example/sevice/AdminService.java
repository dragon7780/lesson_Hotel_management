package org.example.sevice;

import org.example.dto.Room;
import org.example.entity.RoomEntity;
import org.example.enums.RoomType;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private RoomRepository roomRepository;
    public boolean addRoom(int number, Integer stage, RoomType type, Double price, int area) {
        RoomEntity roomByNum = roomRepository.getRoomByNum(number, stage);
        if(roomByNum != null){
            return false;
        }
        Room room=new Room();
        room.setNumber(number);
        room.setStage(stage);
        room.setType(type);
        room.setPrice(price);
        room.setArea(area);
        roomRepository.save(room);
        return true;
    }
}
