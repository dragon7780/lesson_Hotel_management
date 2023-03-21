package org.example.sevice;

import org.example.entity.RoomEntity;
import org.example.enums.RoomType;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    private RoomRepository roomRepository;
    public boolean addRoom(int number, Integer stage, RoomType type, Double price, int area) {
        RoomEntity roomByNum = roomRepository.getRoomByNum(number, stage);
        if(roomByNum != null){
            return false;
        }
        RoomEntity room=new RoomEntity();
        room.setNumber(number);
        room.setStage(stage);
        room.setType(type);
        room.setPrice(price);
        room.setArea(area);
        roomRepository.save(room);
        return true;
    }

    public void deleteById(int id) {
        RoomEntity byId = roomRepository.getById(id);
        if(byId != null){
            return;
        }
        roomRepository.deleteById(id);
    }

    public void updateRoom(int id, int number, Integer stage, RoomType type, Double price, int area) {
        RoomEntity byId = roomRepository.getById(id);
        if (byId != null){
            return;
        }
        RoomEntity room=new RoomEntity();
        room.setId(id);
        room.setId(number);
        room.setPrice(price);
        room.setStage(stage);
        room.setType(type);
        room.setArea(area);
        roomRepository.update(room);
    }
}
