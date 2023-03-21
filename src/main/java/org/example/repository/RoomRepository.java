package org.example.repository;

import org.example.dto.Room;
import org.example.entity.RoomEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(RoomEntity room){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(room);
        transaction.commit();
        session.close();
    }
    public RoomEntity getRoomByNum(Integer number,Integer stage){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Query<RoomEntity> query = session.createQuery("from RoomEntity WHERE number=:number and stage=:stage", RoomEntity.class);
        query.setParameter("number",number);
        query.setParameter("stage",stage);
        RoomEntity singleResult = query.getSingleResult();
        session.close();
        return singleResult;
    }
    public List<RoomEntity> getAll(){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query<RoomEntity> from_roomEntity_ = session.createQuery("from RoomEntity ", RoomEntity.class);
        List<RoomEntity> resultList = from_roomEntity_.getResultList();
        session.close();
        return resultList;
    }

    public RoomEntity getById(int id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        RoomEntity roomEntity = session.find(RoomEntity.class, id);
        session.close();
        transaction.commit();
        return roomEntity;
    }
    public void deleteById(int id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createQuery("delete from RoomEntity where id=:id ");
        session.close();
        transaction.commit();
    }

    public void update(RoomEntity byId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(byId);
    }

}
