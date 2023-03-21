package org.example.sevice;

import org.example.entity.ConvenientEntity;
import org.example.entity.RoomConvenientEntity;
import org.example.repository.ConvenientRepository;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvenientService {
    @Autowired
    private ConvenientRepository convenientRepository;
    @Autowired
    private RoomRepository roomRepository;

    public void addConvenient(String name) {
        ConvenientEntity convenient=new ConvenientEntity();
        convenient.setConvenient(name);
        convenientRepository.save(convenient);
    }

    public void saveConvenient(int room, int con) {
        RoomConvenientEntity roomConvenientEntity=new RoomConvenientEntity();
        roomConvenientEntity.setConvenient_id(convenientRepository.getConvenientById(con));
        roomConvenientEntity.setRoom(roomRepository.getById(room));
        convenientRepository.save(roomConvenientEntity);
    }

    public void deleteById(int id) {
        ConvenientEntity convenientById = convenientRepository.getConvenientById(id);
        if (convenientById == null){
            return;
        }
        convenientRepository.deleteById(id);
    }
}
