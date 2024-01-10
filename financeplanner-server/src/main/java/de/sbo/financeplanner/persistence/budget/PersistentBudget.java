package de.sbo.financeplanner.persistence.budget;

import java.time.LocalDate;
import java.util.Set; 
import de.sbo.financeplanner.domain.budget.BudgetEntry;
import de.sbo.financeplanner.persistence.account.PersistentAccount;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class PersistentBudget {

    @Id
    @GeneratedValue
    private Long id;
    
    private PersistentAccount owner;

    private Set<PersistentBudgetEntry> budgetEntries;

    private String description;


}
