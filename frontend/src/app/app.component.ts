import { Component } from '@angular/core';
import {SessionService} from './service/session.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'frontend';
 constructor(private route: Router, private SessionService: SessionService) {}


  gotoMemHome() {
    this.route.navigate(['MemHome']);
  }



}
