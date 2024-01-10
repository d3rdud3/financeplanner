package de.sbo.financeplanner.persistence.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.history.RevisionRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<PersistentAccount, Long>, RevisionRepository<PersistentAccount, Long, Long> {
    



}
