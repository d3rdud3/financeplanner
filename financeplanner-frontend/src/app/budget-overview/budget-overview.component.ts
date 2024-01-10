import { Component } from '@angular/core';
import { BudgetListComponent } from './budget-list/budget-list.component';

@Component({
  selector: 'app-budget-overview',
  standalone: true,
  imports: [BudgetListComponent],
  templateUrl: './budget-overview.component.html',
  styleUrl: './budget-overview.component.sass'
})
export class BudgetOverviewComponent {

}
