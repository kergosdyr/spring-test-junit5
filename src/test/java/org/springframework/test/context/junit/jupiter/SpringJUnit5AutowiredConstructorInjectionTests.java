/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.test.context.junit.jupiter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.TestPropertySource;
import comics.Dog;
import comics.Person;

/**
 * Integration tests which demonstrate support for {@link Autowired @Autowired}
 * test class constructors with the Spring TestContext Framework and JUnit 5.
 *
 * <p>To run these tests in an IDE, simply run {@link SpringExtensionTestSuite}
 * as a JUnit 4 test.
 *
 * @author Sam Brannen
 * @since 5.0
 * @see SpringExtension
 * @see SpringJUnit5ConstructorInjectionTests
 */
@SpringJUnitJupiterConfig(TestConfig.class)
@TestPropertySource(properties = "enigma = 42")
class SpringJUnit5AutowiredConstructorInjectionTests {

	final ApplicationContext applicationContext;
	final Person dilbert;
	final Dog dog;
	final Integer enigma;

	@Autowired
	SpringJUnit5AutowiredConstructorInjectionTests(ApplicationContext applicationContext, Person dilbert, Dog dog,
			@Value("${enigma}") Integer enigma) {

		this.applicationContext = applicationContext;
		this.dilbert = dilbert;
		this.dog = dog;
		this.enigma = enigma;
	}

	@Test
	void applicationContextInjected() {
		assertNotNull(applicationContext, "ApplicationContext should have been injected by Spring");
		assertEquals(this.dilbert, applicationContext.getBean("dilbert", Person.class));
	}

	@Test
	void beansInjected() {
		assertNotNull(this.dilbert, "Dilbert should have been @Autowired by Spring");
		assertEquals("Dilbert", this.dilbert.getName(), "Person's name");

		assertNotNull(this.dog, "Dogbert should have been @Autowired by Spring");
		assertEquals("Dogbert", this.dog.getName(), "Dog's name");
	}

	@Test
	void propertyPlaceholderInjected() {
		assertNotNull(this.enigma, "Enigma should have been injected via @Value by Spring");
		assertEquals(new Integer(42), this.enigma, "enigma");
	}

}
