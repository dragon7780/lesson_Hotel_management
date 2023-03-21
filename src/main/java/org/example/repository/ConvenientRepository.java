package org.example.repository;

import org.example.entity.ConvenientEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ConvenientRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public ConvenientEntity getById(Integer room, Integer con){
        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        Session session = factory.openSession();
        Query<ConvenientEntity> query = session.createQuery("from ConvenientEntity where room=:room and id=:con", ConvenientEntity.class);
        query.setParameter("room",room);
        query.setParameter("con",con);
        ConvenientEntity singleResult = query.getSingleResult();
        return singleResult;
    }
}
