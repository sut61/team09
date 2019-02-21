import { Component, OnInit } from '@angular/core';
import { MemRegService } from '../service/memReg.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';
import {MatSnackBar} from '@angular/material';


@Component({
  selector: 'app-member-registion',
  templateUrl: './member-registion.component.html',
  styleUrls: ['./member-registion.component.css']
})
export class MemberRegistionComponent implements OnInit {
Categories : Array<any>;
Provinces : Array<any>;
Agent : Array<any>;

Member : any ={ fName: '', lName: '', olds: '',PID: '' ,username: '' ,password: '',typeName: '',povin: '' , agnt: '' , addes: '' };

  constructor(private MemRegService : MemRegService , private httpClient: HttpClient, private router:Router ,private snackBar: MatSnackBar) {}

  ngOnInit() {
   this.MemRegService.getCategory().subscribe(dataF => { this.Categories = dataF; console.log(this.Categories);});
   this.MemRegService.getProvince().subscribe(dataE => { this.Provinces = dataE; console.log(this.Provinces);});
   this.MemRegService.getAgent().subscribe(dataG => { this.Agent = dataG; console.log(this.Agent);});

  }


   save() {
       if (this.Member.fName == ''){this.snackBar.open("กรุณากรอก ชื่อ ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.fName.length > 20){this.snackBar.open("ชื่อ ไม่ยาวกว่า 20 ตัวอักษร", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.fName.length < 2){this.snackBar.open("ชื่อ ไม่ต่ำกว่า 2 ตัวอักษร ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.lName == ''){this.snackBar.open("กรุณากรอก นามสกุล ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.lName.length > 20){this.snackBar.open("นามสกุล ไม่ยาวกว่า 20 ตัวอักษร", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.lName.length < 2){this.snackBar.open("นามสกุล ไม่ต่ำกว่า 2 ตัวอักษร ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.PID == ''){this.snackBar.open("กรุณากรอก หมายเลขบัตรประชาชน ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (/[0-9]{13}/.test(this.Member.PID)=== false){this.snackBar.open("เลขประชาชนต้องเป็นตัวเลข 13 หลักเท่านั้น", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.Olds == null){this.snackBar.open("กรุณากรอก อายุ ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if(this.Member.Olds < 1 || this.Member.Olds > 80){this.snackBar.open("อายุไม่ควรต่ำกว่า 1 ปี และไม่เกิน 80 ปี ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});  }
       else if (this.Member.username == ''){this.snackBar.open("กรุณากรอก username ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.password == ''){this.snackBar.open("กรุณากรอก password ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.Member.addes == ''){this.snackBar.open("กรุณากรอก ที่อยู่ของท่าน ", "ลองใหม่", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
        else{
          this.httpClient.post('http://localhost:8080/Regmem/' +
           this.Member.fName + '/' + this.Member.lName + '/' + this.Member.Olds + '/'
           + this.Member.PID + '/' + this.Member.username + '/' + this.Member.password + '/' + this.Member.povin  + '/' +
           this.Member.agnt + '/' + this.Member.typeName +'/' + this.Member.addes
          ,this.Member)
            .subscribe(
               data => {

               },
               error => { console.log('Rrror', error); alert('ล้มเหลว!'); }


            );               alert('ลงทะเบียนสำเร็จ!');

          }
      }

}
