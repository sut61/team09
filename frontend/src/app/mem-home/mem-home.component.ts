import { Component, OnInit } from '@angular/core';
import {memHomeService} from '../service/memHome.service';
import { HttpClient } from '@angular/common/http';
import {MatSnackBar} from '@angular/material';
import {Router} from '@angular/router';

@Component({
selector: 'app-mem-home',
templateUrl: './mem-home.component.html',
styleUrls: ['./mem-home.component.css']
})
export class MemHomeComponent implements OnInit {
displayedColumns: string[] = ['id','amount','code','date'];
displayedColumns1: string[] = ['id','amount','code','date'];
User : Array<any>;
Paid : Array<any>;
Cost : Array<any>;

code : any = { code : '' } ;

constructor(private memHomeService: memHomeService , private httpClient: HttpClient  ,private snackBar: MatSnackBar ,private route: Router) { }

  ngOnInit() {
  this.memHomeService.getUser(localStorage.getItem('currentUser')).subscribe(data => {
   this.User = data; console.log(this.memHomeService);});
  this.memHomeService.getCost(localStorage.getItem('currentUser')).subscribe(dataa => { this.Cost = dataa; console.log(this.memHomeService);});
   this.memHomeService.getPaid(localStorage.getItem('currentUser')).subscribe(datab => { this.Paid = datab; console.log(this.memHomeService);});
  }

  submit(){
         if (this.code.code == null) {alert('กรุณาใส่ข้อมูลให้ครบถ้วน');}

          else{
            this.httpClient.delete('http://localhost:8080/pay/' + this.code.code
            ,this.code)
              .subscribe(
                 data => {
                 console.log(this.code)
                  console.log('PUT Request is successful', data);
                  {this.snackBar.open("ชำระเสร็จสิ้น", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
                  this.route.navigate(['MemHome']);
                  }

                 },
                 error => { console.log('Rrror', error); this.snackBar.open("กรุณาตรวจสอบรหัสชำระ ท่านกรอกไม่ถูกต้อง", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
              );

            }
        }


}
