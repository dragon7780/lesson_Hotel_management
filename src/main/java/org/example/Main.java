package org.example;

import org.example.controller.AuthController;
import org.example.config.Config;
import org.example.dto.Room;
import org.example.entity.RoomEntity;
import org.example.enums.RoomType;
import org.example.repository.RoomRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
//        Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
//        SessionFactory factory = meta.getSessionFactoryBuilder().build();
        ApplicationContext context=new AnnotationConfigApplicationContext(Config.class);
        AuthController authController = (AuthController) context.getBean("authController");
        authController.start();
    }
}