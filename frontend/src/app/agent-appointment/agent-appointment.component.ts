import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../service/appointment.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';
import { MatSnackBar } from '@angular/material';

@Component({
selector: 'app-agent-appointment',
templateUrl: './agent-appointment.component.html',
styleUrls: ['./agent-appointment.component.css']
})
export class AgentAppointmentComponent implements OnInit {
Categories : Array<any>;
Genders: Array<any>;
Date : Array<any>;
Duration : Array<any>;
Provinces : Array<any>;
Appointment : any = {typeName: '', fName: '', lName: '', idCardNum: '' ,genderName: '', age: '', telNum: '',email: '' , provinceName: '', date: '',  duration: ''};
DateCount : number;
constructor(private appointService : AppointmentService ,private httpClient: HttpClient, private router:Router,private snackBar: MatSnackBar) { }
  ngOnInit() {
    this.appointService.getAppointment().subscribe(data => { this.Appointment = data; console.log(this.Appointment);});
    this.appointService.getCategory().subscribe(dataF => { this.Categories = dataF; console.log(this.Categories);});
    this.appointService.getGender().subscribe(dataB => { this.Genders = dataB; console.log(this.Genders);});
    this.appointService.getDateAppointment().subscribe(dataC => { this.Date = dataC; console.log(this.Date);});
    this.appointService.getDurationAppointment().subscribe(dataD => { this.Duration = dataD; console.log(this.Duration);});
    this.appointService.getProvince().subscribe(dataE => { this.Provinces = dataE; console.log(this.Provinces);});
  }

   save() {
      if(this.Appointment.typeName == null)
      { this.snackBar.open("กรุณาเลือกประเภทประกันที่สนใจ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.fName == null)
      { this.snackBar.open("กรุณากรอกชื่อจริง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.fName.length > 30)
      { this.snackBar.open("ความยาวชื่อจริงไม่ควรเกิน 30 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.fName.length < 2)
      { this.snackBar.open("ความยาวชื่อจริงต้องมากกว่า 2 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.lName == null)
      { this.snackBar.open("กรุณากรอกนามสกุล", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.lName.length > 30)
      { this.snackBar.open("ความยาวนามสกุลไม่ควรเกิน 30 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.lName.length < 2)
      { this.snackBar.open("ความยาวนามสกุลต้องมากกว่า 2 ตัวอักษร", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.idCardNum == null)
      { this.snackBar.open("กรุณากรอกรหัสบัตรประชาชน", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(/[0-9]{13}/.test(this.Appointment.idCardNum) === false)
      { this.snackBar.open("รูปแบบรหัสบัตรประชาชนไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.genderName == null)
      { this.snackBar.open("กรุณาเลือกเพศ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.age == null)
      { this.snackBar.open("กรุณากรอกอายุ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.age < 1 || this.Appointment.age > 80)
      { this.snackBar.open("อายุไม่อยู่ในช่วงที่กำหนด", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.telNum == null)
      { this.snackBar.open("กรุณากรอกเบอร์โทรศัพท์", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(/[0]{1}[2-9]{1}[0-9]{8}/.test(this.Appointment.telNum) === false)
      { this.snackBar.open("รูปแบบเบอร์โทรศัพท์ไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.email == null)
      { this.snackBar.open("กรุณากรอก email", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(/[A-Za-z0-9][A-Za-z0-9.]{7}[A-Za-z0-9.]*@[a-z]+.[a-z.]+/.test(this.Appointment.email) === false)
      { this.snackBar.open("รูปแบบ email ไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.provinceName == null)
      { this.snackBar.open("กรุณาเลือกจังหวัดที่ต้องการ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.date == null)
      { this.snackBar.open("กรุณาเลือกวันที่ต้องการ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
      else if(this.Appointment.duration == null)
      { this.snackBar.open("กรุณาเลือกเวลาที่ต้องการ", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

      else{
        this.appointService.getDateCount(this.Appointment.date).subscribe(dataF => { this.DateCount = dataF; console.log(this.DateCount);});

        this.httpClient.post('http://localhost:8080/MakeAppointment/' + this.Appointment.typeName + '/'
        + this.Appointment.fName + '/' + this.Appointment.lName + '/' + this.Appointment.idCardNum + '/'
        + this.Appointment.genderName + '/' + this.Appointment.age + '/' + this.Appointment.telNum + '/'
        + this.Appointment.email + '/' + this.Appointment.provinceName + '/'+ this.Appointment.date + '/'
        + this.Appointment.duration
        ,this.Appointment)
          .subscribe(
             data => {
              console.log(this.Appointment)
              const Appointment  = this.Appointment
              this.router.navigate(['showAppointmentResult',{ typeName:Appointment.typeName, fName:Appointment.fName
              , lName:Appointment.lName , idCardNum:Appointment.idCardNum , genderName :this.Appointment.genderName
              , age:Appointment.age , telNum:Appointment.telNum, email:Appointment.email, provinceName:Appointment.provinceName
              , date:Appointment.date, duration:Appointment.duration}])
              console.log('PUT Request is successful', data);

             },
             error => {
             console.log('Rrror', error);
                if(this.DateCount == 4){
                  this.snackBar.open("วันนัดเต็มแล้ว! กรุณาเลือกวันนัดอื่น", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"});
                }else{
                  let snackBarRef = this.snackBar.open('รหัสบัตรประชาชนนี้ มีในประวัติการนัดแล้ว! กรุณายกเลิกนัดเดิมก่อนทำรายการ', 'ตกลง',{
                        verticalPosition:"top", horizontalPosition: "center" });
                }
             }
          );
        }
      }
}
