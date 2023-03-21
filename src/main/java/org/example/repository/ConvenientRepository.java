package org.example.repository;

import org.example.entity.ConvenientEntity;
import org.example.entity.RoomConvenientEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ConvenientRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void save(ConvenientEntity convenientEntity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(convenientEntity);
        transaction.commit();
        session.close();
    }
    public ConvenientEntity getConvenientById(Integer id){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        ConvenientEntity convenient = session.find(ConvenientEntity.class, id);
        return convenient;
    }

    public void save(RoomConvenientEntity roomConvenientEntity){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(roomConvenientEntity);
        transaction.commit();
        session.close();
    }
    public List<ConvenientEntity> geAll(){
        Session session = sessionFactory.openSession();
        NativeQuery<ConvenientEntity> nativeQuery = session.createNativeQuery
                ("select * from convenient as con inner join room_convenient as room on con.id=room.id", ConvenientEntity.class);
        List<ConvenientEntity> resultList = nativeQuery.getResultList();
        return resultList;
    }

    public void deleteById(int id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("delete from ConvenientEntity where id=:id");
        query.setParameter("id",id);
        session.close();
    }
}
