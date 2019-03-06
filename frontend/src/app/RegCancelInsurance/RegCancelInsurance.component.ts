import {HttpClient} from '@angular/common/http';
import {FormControl} from '@angular/forms';
import {Component,OnInit} from '@angular/core';
import { Router } from '@angular/router';
import {RegCancelInsuranceService} from  '../service/RegCancelInsurance.Service';
import {memHomeService} from '../service/memHome.service';
import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-RegCancelInsurance',
  templateUrl: './RegCancelInsurance.component.html',
  styleUrls: ['./RegCancelInsurance.component.css']
}
)
export class RegCancelInsuranceComponent implements OnInit {
reasonMembers : Array<any>;
private User :  number;

cancelInsurances : any = {idCard: '', fName: '', lName: '', eMail: '', tlePhone: '', reasonMemberName: ''};

constructor(private Service : RegCancelInsuranceService ,
            private memHomeService: memHomeService,private httpClient: HttpClient,
            private router:Router ,private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.Service.getCancelInsurances().subscribe(dataMe => {
                    this.cancelInsurances = dataMe;
                    console.log(this.cancelInsurances);
     });
  this.Service.getmems(localStorage.getItem('currentUser')).subscribe(data => {
   this.User = data; console.log(this.memHomeService);});


    this.Service.getReasonMembers().subscribe(dataA => {
                    this.reasonMembers = dataA;
                    console.log(this.reasonMembers);
      });
  }

 /**====SAVE====*/
  save() {
      if(
      this.cancelInsurances.idCard === '' ||
      this.cancelInsurances.fName === ''||
      this.cancelInsurances.lName === ''  ||
      this.cancelInsurances.eMail === ''  ||
      this.cancelInsurances.tlePhone === ''  ||
      this.cancelInsurances.reasonMemberName === ''){

      this.snackBar.open("กรุณใส่ข้อมูลให้ครบ", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
  else if(this.cancelInsurances.idCard == null){
          this.snackBar.open("กรุณากรอกรหัสประจำตัวประชาชน", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
else if(this.cancelInsurances.fName == null){
          this.snackBar.open("กรุณากรอกชื่อ", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
else if(this.cancelInsurances.lName == null){
          this.snackBar.open("กรุณากรอกนามสกุล", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
else if(this.cancelInsurances.eMail == null){
          this.snackBar.open("กรุณากรอกอีเมลย์", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
else if(this.cancelInsurances.tlePhone == null){
          this.snackBar.open("กรุณากรอกเบอร์โทร", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }


  else if(this.cancelInsurances.fName.length < 2){
          this.snackBar.open("ชื่อสั้นเกินไป ต้องมีอน่างน้อย 2 ตัว!", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
else if(this.cancelInsurances.fName.length > 30){
          this.snackBar.open("ชื่อยาวเกินไป ต้องไม่เกิน 20", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
else if(this.cancelInsurances.lName.length < 2){
          this.snackBar.open("นามสกุลสั้นเกินไป ต้องมีอน่างน้อย 2 ตัว!", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
else if(this.cancelInsurances.lName.length > 30){
          this.snackBar.open("นามสกุลยาวเกินไป ต้องไม่เกิน 30 ตัว", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }


    else if(/[0-9]{13}/.test(this.cancelInsurances.idCard) === false){
          this.snackBar.open("กรอกขรหัสประจำตัวประชาชนให้ถูกต้อง", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

      }
else if(/[A-Za-z0-9][A-Za-z0-9.]{5}[A-Za-z0-9.]*@[a-z]+.[a-z.]+/.test(this.cancelInsurances.eMail) === false){
          this.snackBar.open("กรอกขอีเมลย์ให้ถูกต้อง", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});

      }
else if(/[0]{1}[2-9]{1}[0-9]{8}/.test(this.cancelInsurances.tlePhone) === false ){
          this.snackBar.open("กรอกขเบอร์โทรศัพท์ให้ถูกต้อง", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
else if(this.cancelInsurances.reasonMemberName == null){
          this.snackBar.open("กรุณาเลือกเหตุผลในการยกเลิก", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }


      else {
        this.httpClient.delete('http://localhost:8080/CancelInsurance/'
        + this.User +'/'
        + this.cancelInsurances.idCard + '/'
        + this.cancelInsurances.fName + '/'
        + this.cancelInsurances.lName  + '/'
        + this.cancelInsurances.eMail  + '/'
        + this.cancelInsurances.tlePhone  + '/'
        + this.cancelInsurances.reasonMemberName,
        this.cancelInsurances)
        .subscribe(
           data => {
              console.log('PUT Request is successful', data);
              console.log(this.cancelInsurances)
                               const cancelInsurances  = this.cancelInsurances
                               this.router.navigate(['ShowCancelInsurance',{
                               idCard:cancelInsurances.idCard,
                               fName:cancelInsurances.fName,
                               lName:cancelInsurances.lName,
                               eMail:cancelInsurances.eMail,
                               tlePhone:cancelInsurances.tlePhone,
                               reasonMemberName:cancelInsurances.reasonMemberName}])

                    let snackBarRef = this.snackBar.open('ยกเลิกสำเร็จ','ตกลง',{
                      verticalPosition:"top",
                      horizontalPosition: "center"
                });
           },
           error => {
              console.log('Rrror', error);
                let snackBarRef = this.snackBar.open('ไม่สามารถยกเลิกสมาชิกได้','ตกลง',{
                      verticalPosition:"top",
                      horizontalPosition: "center"
              });
            }
        );

     }
  }
}
