package org.example.repository;

import org.example.dto.Room;
import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public class RoomRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(Room room){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        session.close();
        transaction.commit();
    }
    public RoomEntity getRoomByNum(Integer number,Integer stage){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<RoomEntity> query = session.createQuery("FROM RoomEntity WHERE number=:number and stage=:stage", RoomEntity.class);
        query.setParameter("number",number);
        query.setParameter("stage",stage);
        RoomEntity singleResult = query.getSingleResult();
        return singleResult;
    }
}
