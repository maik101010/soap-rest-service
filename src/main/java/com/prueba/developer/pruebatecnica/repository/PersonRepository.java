package com.prueba.developer.pruebatecnica.repository;

import com.prueba.developer.pruebatecnica.entity.PersonEntity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PersonRepository extends PagingAndSortingRepository<PersonEntity, Long> {
    //select c from Cliente c where c.precio > ?1 AND c.id = ?2
    List<PersonEntity> findBySalaryGreaterThan(@Param("salary") double salary);
}
