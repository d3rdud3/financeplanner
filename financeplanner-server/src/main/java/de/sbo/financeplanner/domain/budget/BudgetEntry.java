package de.sbo.financeplanner.domain.budget;

import java.time.LocalDateTime;

public class BudgetEntry {

    private Category category;

    private float value;

    private LocalDateTime createdAt;

    private int createdByUserId;
}
