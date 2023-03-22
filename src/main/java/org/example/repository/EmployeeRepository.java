package org.example.repository;

import org.example.entity.EmployeeEntity;
import org.example.entity.EmployeeTypeEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
    @Autowired
    private SessionFactory sessionFactory;
    public void saveType(EmployeeTypeEntity employeeType) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employeeType);
        transaction.commit();
        session.close();
    }
    public List<EmployeeTypeEntity> getAll(){
        Session session = sessionFactory.openSession();
        Query<EmployeeTypeEntity> employeeTypeEntity = session.createQuery("FROM EmployeeTypeEntity", EmployeeTypeEntity.class);
        List<EmployeeTypeEntity> resultList = employeeTypeEntity.getResultList();
        session.close();
        return resultList;
    }
    public EmployeeTypeEntity getEmployeeTypeById(Integer id){
        Session session = sessionFactory.openSession();
        EmployeeTypeEntity employeeType = session.find(EmployeeTypeEntity.class, id);
        session.close();
        return employeeType;
    }
    public void deleteEmployeeTypeById(Integer id){
        Session session = sessionFactory.openSession();
        Query<EmployeeTypeEntity> query = session.createQuery("delete from EmployeeTypeEntity where id=:id", EmployeeTypeEntity.class);
        query.setParameter("id",id);
        session.close();
    }
    public void saveEmployee(EmployeeEntity employee) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(employee);
        transaction.commit();
        session.close();
    }
    public List<EmployeeEntity> getAllEmployee(){
        Session session = sessionFactory.openSession();
        Query<EmployeeEntity> employeeTypeEntity = session.createQuery("FROM EmployeeEntity", EmployeeEntity.class);
        List<EmployeeEntity> resultList = employeeTypeEntity.getResultList();
        session.close();
        return resultList;
    }
    public EmployeeEntity getEmployeeById(Integer id){
        Session session = sessionFactory.openSession();
        EmployeeEntity employeeType = session.find(EmployeeEntity.class, id);
        session.close();
        return employeeType;
    }
    public void deleteEmployeeById(Integer id){
        Session session = sessionFactory.openSession();
        Query<EmployeeEntity> query = session.createQuery("delete from EmployeeEntity where id=:id", EmployeeEntity.class);
        query.setParameter("id",id);
        session.close();
    }
}
