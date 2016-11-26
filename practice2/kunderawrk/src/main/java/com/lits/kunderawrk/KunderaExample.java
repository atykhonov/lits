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
        user.setFirst_name("John");
        user.setLast_name("Smith");
        user.setDate_of_birth(new Date());

        //enable CQL3
        Map<String, String> props = new HashMap<>();
        // props.put(CassandraConstants.CQL_VERSION, CassandraConstants.CQL_VERSION_3_0);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hbase_pu", props);
        EntityManager em = emf.createEntityManager();

        em.persist(user);
        em.close();    
        emf.close();    
    }
}
