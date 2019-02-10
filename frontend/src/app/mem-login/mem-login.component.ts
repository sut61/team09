import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../service/login.service';

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

  constructor(private route: Router, private loginService: LoginService) { }

  ngOnInit() {

  }

  login() {
    this.loginService.signin(this.user).subscribe(   value => {}, error1 => {}, () => {
       this.loginService.saveUser(this.user.username);
      this.route.navigate(['MemHome']);
    });
  }

}
