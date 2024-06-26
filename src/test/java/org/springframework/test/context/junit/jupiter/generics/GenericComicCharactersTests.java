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

package org.springframework.test.context.junit.jupiter.generics;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.TestConfig;
import comics.Character;

/**
 * Abstract base class for integration tests that demonstrate support for
 * Java generics in JUnit 5 test classes when used with the Spring TestContext
 * Framework and the {@link SpringExtension}.
 *
 * @author Sam Brannen
 * @since 5.0
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = TestConfig.class)
abstract class GenericComicCharactersTests<T extends Character> {

	@Autowired
	T character;

	@Autowired
	List<T> characters;

	@Test
	void autowiredFields() {
		assertNotNull(this.character, "Character should have been @Autowired by Spring");
		assertEquals(getExpectedName(), character.getName(), "character's name");
		assertEquals(getExpectedNumCharacters(), this.characters.size(), "Number of characters in context");
	}

	@Test
	void autowiredParameterByTypeForSingleGenericBean(@Autowired T character) {
		assertNotNull(character, "Character should have been @Autowired by Spring");
		assertEquals(getExpectedName(), character.getName(), "character's name");
	}

	abstract int getExpectedNumCharacters();

	abstract String getExpectedName();

}
