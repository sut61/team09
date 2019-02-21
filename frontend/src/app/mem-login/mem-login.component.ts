import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {LoginService} from '../service/login.service';
import {MatSnackBar} from '@angular/material';

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

  constructor(private route: Router, private loginService: LoginService ,private snackBar: MatSnackBar ) { }

  ngOnInit() {

  }

  login() {

    this.loginService.signin(this.user).subscribe(   value => {}, error1 => {this.snackBar.open("username หรือ password ไม่ถูกต้อง", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}, () => {
    this.snackBar.open("เข้าสู่ระบบสำเร็จ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
       this.loginService.saveUser(this.user.username);
      this.route.navigate(['MemHome']);
    });
  }

}
