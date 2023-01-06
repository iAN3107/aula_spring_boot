package com.cutti.api_diso.repository;

import com.cutti.api_diso.data.vo.v1.PersonVO;
import com.cutti.api_diso.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
