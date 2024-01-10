package de.sbo.financeplanner.domain.person;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

@Entity
class Person {

	@Id @GeneratedValue
	Long id;
	String name;
	@Version Long version;
}
