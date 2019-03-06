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
displayedColumns1: string[] = ['id','amount','code', 'date' ];
User : Array<any>;
Paid : Array<any>;
Cost : Array<any>;
Method  : Array<any>;

code : any = { code : '' , method : ''  , num : '' , exp :'' } ;

constructor(private memHomeService: memHomeService , private httpClient: HttpClient  ,private snackBar: MatSnackBar ,private route: Router) { }

  ngOnInit() {
  this.memHomeService.getUser(localStorage.getItem('currentUser')).subscribe(data => {
   this.User = data; console.log(this.memHomeService);});
  this.memHomeService.getCost(localStorage.getItem('currentUser')).subscribe(dataa => { this.Cost = dataa; console.log(this.memHomeService);});
   this.memHomeService.getPaid(localStorage.getItem('currentUser')).subscribe(datab => { this.Paid = datab; console.log(this.memHomeService);});
    this.memHomeService.getMethod().subscribe(datac => { this.Method = datac; console.log(this.memHomeService);});
  }

  submit(){
         if (this.code.code == '') {this.snackBar.open("กรุณาป้อน code ชำระ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (this.code.code.length < 8 ) {this.snackBar.open("code ชำระ ไม่ต่ำกว่า 8 ตัวอักษร ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (this.code.code.length > 8 ) {this.snackBar.open("code ชำระ ไม่เกิน 8 ตัวอักษร ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (this.code.num == '') {this.snackBar.open("กรุณาป้อน หมายเลขบัตร", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (this.code.num.length < 10 ) {this.snackBar.open("หมายเลขบัตร  ไม่ต่ำกว่า 10 ตัวอักษร ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (this.code.num.length > 10 ) {this.snackBar.open("หมายเลขบัตร  ไม่เกิน 10 ตัวอักษร ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (/[0-9]{10}/.test(this.code.num)=== false ) {this.snackBar.open( "หมายเลขบัตร ต้องเป็นตัวเลขเท่านั้น", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (this.code.exp == '') {this.snackBar.open("กรุณาป้อน ปีที่บัตรหมดอายุ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (this.code.exp.length < 2 ) {this.snackBar.open("ปีที่บัตรหมดอายุ  ไม่ต่ำกว่า 2 ตัวอักษร ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (this.code.exp.length > 2 ) {this.snackBar.open("ปีที่บัตรหมดอายุ  ไม่เกิน 2 ตัวอักษร ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
         else if (/[0-9]{2}/.test(this.code.exp)=== false ) {this.snackBar.open( "ปีที่บัตรหมดอายุ ต้องเป็นตัวเลขเท่านั้น", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});}
          else{
            this.httpClient.delete('http://localhost:8080/pay/' + this.code.code + '/' + this.code.method + '/' + this.code.num + '/' + this.code.exp
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
