import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../service/login.service';
import {SessionService} from '../service/session.service';

@Component({
  selector: 'app-mem-login',
  templateUrl: './mem-login.component.html',
  styleUrls: ['./mem-login.component.css']
})
export class MemLoginComponent implements OnInit {

  user: any = {
    username: '',
    password: ''
  };

  constructor(private route: Router, private loginService: LoginService, private SessionService: SessionService) { }

  ngOnInit() {
    if (this.SessionService.getUsername()) {
    }
  }

  login() {
    this.loginService.signin(this.user).subscribe(value => {}, error1 => {}, () => {
      this.SessionService.saveUsername(this.user.username);
      this.route.navigate(['MemHome']);
    });
  }

}
