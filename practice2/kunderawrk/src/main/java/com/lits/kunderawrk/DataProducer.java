package com.lits.kunderawrk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.lang.ArrayUtils;
import org.fluttercode.datafactory.impl.DataFactory;


public class DataProducer {

    public static void main(String[] args)
    {
		List<String> specializations = new ArrayList<String>();
		specializations.add("therapist");
		specializations.add("dentist");
		specializations.add("ophthalmologist");

        Map<String, String> props = new HashMap<>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hbase_pu", props);
        EntityManager em = emf.createEntityManager();

    	DataFactory df = new DataFactory();

    	for (int ph = 0; ph < 1000; ph++) {
    		Physician physician = new Physician();
    		String phFirstName = df.getFirstName();
    		String phLastName = df.getLastName();
    		String phFullName = phFirstName.concat(" ").concat(phLastName);
    		physician.setId(phFullName.getBytes());
    		physician.setFullName(phFullName);
    		physician.setClinicName(df.getRandomWord());
    		physician.setSpecialization(df.getItem(specializations));
    		for (int p = 0; p < 1000; p++) {
    			Patient patient = new Patient();
    			String pFirstName = df.getFirstName();
    			String pLastName = df.getLastName();
    		    // patient.setId();
    			patient.setId(ArrayUtils.addAll(physician.getId(), patient.getId()));
    			patient.setFirstName(df.getFirstName());
    			patient.setLastName(df.getLastName());
    			patient.setDateOfBirth(df.getBirthDate());
            	for (int mr = 0; mr < 1000; mr++) {
                    // Patient patient = new Patient();
                    byte[] id = phFullName.getBytes();
                    patient.setId(id);
                    patient.setFirstName(phFirstName);
                    patient.setLastName(phLastName);
                    patient.setDateOfBirth(df.getBirthDate());
                    em.persist(patient);
            	}
    		}
    	}

        em.close();
        emf.close();
    }
}
