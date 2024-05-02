package org.springframework.test.context.junit.jupiter.jpa;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.jpa.config.JpaConfig;

import domain.entity.MyEntity;
import domain.repository.MyEntityRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = JpaConfig.class)
public class JpaTest {

	@Autowired
	private MyEntityRepository myEntityRepository;

	@Test
	void name() {

		myEntityRepository.save(new MyEntity());

	}
}
