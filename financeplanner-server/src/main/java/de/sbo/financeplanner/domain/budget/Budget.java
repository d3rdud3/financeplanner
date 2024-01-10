package de.sbo.financeplanner.domain.budget;

import java.time.LocalDate;
import java.util.Set;

import de.sbo.financeplanner.domain.account.Account;

public class Budget {

    private Account owner;

    private Set<BudgetEntry> budgetEntries;

    private LocalDate month;
}