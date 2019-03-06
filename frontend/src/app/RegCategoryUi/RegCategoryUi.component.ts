import { OnInit } from '@angular/core';
import {FormControl} from '@angular/forms';
import { HttpClient} from '@angular/common/http';
import { Router } from '@angular/router';
import {Component} from '@angular/core';
import {RegCategoryUiService} from  '../service/RegCategoryUi.Service';

import { MatSnackBar } from '@angular/material';

@Component({
  selector: 'app-RegCategoryUi',
  templateUrl: './RegCategoryUi.component.html',
  styleUrls: ['./RegCategoryUi.component.css']
}
)

export class RegCategoryUiComponent implements OnInit {
insurancePremiums:Array<any>;
lengths:Array<any>;
moneyMaximums:Array<any>;

categorys:any = {typeName: '', oFName: '', oLName: '', oTlePhone: '', typeNameReason: '', insuranceName: '', lengthName: '', moneyName: ''};


constructor(private Service : RegCategoryUiService ,private httpClient: HttpClient,
            private router:Router ,private snackBar: MatSnackBar) { }

  ngOnInit() {
      this.Service.getCategorys().subscribe(dataMe => {
                    this.categorys = dataMe;
                    console.log(this.categorys);
      });
      this.Service.getInsurancePremiums().subscribe(dataA => {
              this.insurancePremiums = dataA;
              console.log(this.insurancePremiums);
      });
      this.Service.getLengths().subscribe(dataB => {
                          this.lengths = dataB;
                          console.log(this.lengths);
      });
      this.Service.getMoneyMaximums().subscribe(dataC => {
              this.moneyMaximums = dataC;
              console.log(this.moneyMaximums);
        });
      }
      save() {
      if(this.categorys.typeName === '' || this.categorys.oFName === '' ||
      this.categorys.oLName === '' || this.categorys.oTlePhone === '' || this.categorys.typeNameReason === '' ||
        this.categorys.insuranceName === ''||
        this.categorys.lengthName === ''  ||
        this.categorys.moneyName === ''){

      this.snackBar.open("กรุณใส่ข้อมูลให้ครบ!", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});


      }
      else if(this.categorys.typeName == null){
          this.snackBar.open("กรุณากรอกข้อมูลประเภทประกัน", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.oFName == null){
          this.snackBar.open("กรุณากรอกข้อมูลชื่อคนเพิ่มประเภทระกัน", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.oLName == null){
          this.snackBar.open("กรุณากรอกข้อมูลนามสกุลคนเพิ่มประเภทประกัน", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.oTlePhone == null){
          this.snackBar.open("กรุณากรอกข้อมูลเบอร์โทรคนเพิ่มประกัน", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.typeNameReason == null){
          this.snackBar.open("กรุณากรอกข้อมูลหมายเหตุการเพิ่มประกัน", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }


      else if(this.categorys.typeName.length < 6){
          this.snackBar.open("ข้อมูลประเภทประกันต้องมีความยาว ไม่ต่ำกว่า 6 ตัว", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.typeName.length > 20){
          this.snackBar.open("ข้อมูลประเภทประกันต้องมีความยาว ห้ามเกิน 20 ตัว", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.oFName.length < 2){
          this.snackBar.open("ข้อมูลชื่อคนเพิ่มประเภทระกันต้องมีความยาว ไม่ต่ำกว่า 2 ตัว", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.oFName.length > 20){
          this.snackBar.open("ข้อมูลชื่อคนเพิ่มประเภทระกันต้องมีความยาว ห้ามเกิน 20 ตัว", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.oLName.length < 2){
          this.snackBar.open("ข้อมูลนามสกุลคนเพิ่มประเภทประกันต้องมีความยาว ไม่ต่ำกว่า 2 ตัว", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.oLName.length > 20){
          this.snackBar.open("ข้อมูลนามสกุลคนเพิ่มประเภทประกันต้องมีความยาว ห้ามเกิน 20 ตัว", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }

      else if(this.categorys.typeNameReason == null){
          this.snackBar.open("กรุณาเพิ่มหมายเหตุการเพิ่มประกัน!", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(/[0]{1}[2-9]{1}[0-9]{8}/.test(this.categorys.oTlePhone) === false){
          this.snackBar.open("ใส่ข้อมูลเบอร์โทรคนเพิ่มประกันให้ถูกต้อง", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(/^[A-z]*[ก-๐]+|^[ก-๐]*[A-z]+/.test(this.categorys.typeName) === false){
          this.snackBar.open("กรอกข้อมูลประเภทประกันให้ถูกต้อง", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.insuranceName == null){
          this.snackBar.open("กรุณาเลือกจเบี้ยประกัน!", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.lengthName == null){
          this.snackBar.open("กรุณาเลือกวระยะเวลาคุ้มครอง!", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }
      else if(this.categorys.moneyName == null){
          this.snackBar.open("กรุณาเลือกเงินชดเชย!", "ลองใหม่", {
             duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
      }

      else {
        this.httpClient.post('http://localhost:8080/Category/' + this.categorys.typeName + '/'
        + this.categorys.oFName + '/' + this.categorys.oLName + '/' + this.categorys.oTlePhone + '/'
        + this.categorys.typeNameReason + '/'
        + this.categorys.insuranceName + '/'+ this.categorys.lengthName  + '/'
        +this.categorys.moneyName,
        this.categorys)
        .subscribe(
           data => {
              console.log('PUT Request is successful', data);
              console.log(this.categorys)
                               const categorys  = this.categorys
                               this.router.navigate(['ShowCategoryResult',{
                               typeName:categorys.typeName,
                              oFName:categorys.oFName,
                              oLName:categorys.oLName,
                              oTlePhone:categorys.oTlePhone,
                              typeNameReason:categorys.typeNameReason,
                               insuranceName:categorys.insuranceName,
                               lengthName:categorys.lengthName,
                               moneyName:categorys.moneyName}])

                    let snackBarRef = this.snackBar.open('บันทึกสำเร็จ!','ตกลง',{
                    verticalPosition:"top",
                    horizontalPosition: "center"
                });
           },
           error => {
              console.log('Rrror', error);
                let snackBarRef = this.snackBar.open('ประเภทประกันมีอยุ่แล้ว! กรุณาตรวจสอบอีกครั้ง', 'ตกลง',{
                    verticalPosition:"top",
                    horizontalPosition: "center"
                });
            }
        );

     }
  }
}


