package org.springframework.test.context.junit.jupiter.xml;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import domain.entity.MyEntity;
import domain.repository.MyEntityRepository;

@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:application-context.xml")
public class XmlJpaTest {

}
