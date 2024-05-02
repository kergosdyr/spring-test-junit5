package domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import domain.entity.MyEntity;

public interface MyEntityRepository extends JpaRepository<MyEntity, String> {

}
