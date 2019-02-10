import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {SessionService} from '../service/session.service';
@Component({
  selector: 'app-officer-login',
  templateUrl: './OfficerLogin.component.html',
  styleUrls: ['./OfficerLogin.component.css']
})
export class OfficerLoginComponent implements OnInit {

 user: any = {
     username: '',
     password: ''
   };

 constructor(private route: Router, private SessionService: SessionService) { }

   ngOnInit() {
   }
   login() {
     this.SessionService.signin(this.user).subscribe(value => {}, error1 => {}, () => {
       this.route.navigate(['OfficerHome']);
     });
   }


}
