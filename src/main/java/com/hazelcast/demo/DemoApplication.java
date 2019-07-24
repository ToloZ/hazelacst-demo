package com.hazelcast.demo;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.demo.entity.Pais;
import com.hazelcast.demo.entity.Provincia;
import com.hazelcast.demo.repository.PaisRepository;
import com.hazelcast.demo.repository.ProvinciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import javax.annotation.PostConstruct;

@EnableCaching
@SpringBootApplication
public class DemoApplication {

	@Autowired
	private PaisRepository paisRepository;

	@Autowired private ProvinciaRepository provinciaRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		HazelcastInstance hz1 = Hazelcast.newHazelcastInstance();
		HazelcastInstance hz2 = Hazelcast.newHazelcastInstance();
	}


	@PostConstruct
	void started() {
		// Setup
		for (int i = 0; i < 100; i++) {
			Pais p = new Pais();
			p.setcPais((short) i);
			p.setDescripcion("Pais " + Integer.toString(i));
			paisRepository.save(p);
			for (int j = 0; j < 50; j++) {
				Provincia provincia = new Provincia();
				provincia.setcProvincia((short) ((i * 100) + j));
				provincia.setDescripcion("Provincia " + provincia.getcProvincia());
				provincia.setPais(p);
				provinciaRepository.save(provincia);
			}
		}
	}
}
