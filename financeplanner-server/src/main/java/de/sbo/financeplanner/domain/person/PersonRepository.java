package de.sbo.financeplanner.domain.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PersonRepository extends CrudRepository<Person, Long>
{}
