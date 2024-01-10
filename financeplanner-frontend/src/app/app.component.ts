import { Component } from '@angular/core';
import {MatButtonModule} from '@angular/material/button';
import {MatSidenavModule} from '@angular/material/sidenav';
import { ApplicationHeaderComponent } from './application-header/application-header.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [MatSidenavModule, MatButtonModule,ApplicationHeaderComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.sass'
})
export class AppComponent {
  title = 'homes';
  showFiller = true;
  opened = true;
}
