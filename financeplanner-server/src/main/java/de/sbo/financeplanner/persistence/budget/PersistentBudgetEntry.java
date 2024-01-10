package de.sbo.financeplanner.persistence.budget;

import de.sbo.financeplanner.domain.budget.Category;
import java.time.LocalDateTime;

public class PersistentBudgetEntry {

    private PersistentBudgetCategory category;

    private float budgetForCurrentMonth;

    private LocalDateTime createdAt;
}
