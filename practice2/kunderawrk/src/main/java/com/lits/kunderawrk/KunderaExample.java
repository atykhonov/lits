package com.lits.kunderawrk;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class KunderaExample
{
    public static void main(String[] args)
    {
        Patient user = new Patient();
        byte[] id = "patient id".getBytes();
        user.setId(id);
        user.setFirstName("Andrii");
        user.setLastName("Tykhonov");
        user.setDateOfBirth(new Date(1983, 6, 22));

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hbase_pu");
        EntityManager em = emf.createEntityManager();

        em.persist(user);
        em.close();    
        emf.close();    
    }
}
