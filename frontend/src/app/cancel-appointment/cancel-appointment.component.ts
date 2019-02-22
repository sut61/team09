import { Component, OnInit } from '@angular/core';
import { CancelAppointmentService } from '../service/cancel-appointment.service';
import { AppointmentService } from '../service/appointment.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

import { MatSnackBar } from '@angular/material';

@Component({
selector: 'app-cancel-appointment',
templateUrl: './cancel-appointment.component.html',
styleUrls: ['./cancel-appointment.component.css']
})
export class CancelAppointmentComponent implements OnInit {

Date : Array<any>;
Reasons : Array<any>;
CancelAppointment : any = {
idCardNum: '' , reason: ''};
constructor(private appointService : AppointmentService, private cancelService : CancelAppointmentService
  ,private httpClient: HttpClient , private router:Router, private snackBar: MatSnackBar) { }

  ngOnInit() {
    this.cancelService.getCancelAppointment().subscribe(data => { this.CancelAppointment = data; console.log(this.CancelAppointment);});
    this.cancelService.getCancelReason().subscribe(dataB => { this.Reasons = dataB; console.log(this.Reasons);});
    this.appointService.getDateAppointment().subscribe(dataA => { this.Date = dataA; console.log(this.Date);});
  }

  submit(){
       if (this.CancelAppointment.idCardNum == null)
       { this.snackBar.open("กรุณากรอกรหัสบัตรประชาชน", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if(/[0-9]{13}/.test(this.CancelAppointment.idCardNum) === false)
       { this.snackBar.open("รูปแบบรหัสบัตรประชาชนไม่ถูกต้อง", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }
       else if (this.CancelAppointment.reason == null)
        { this.snackBar.open("กรุณาเลือกเหตุผลที่ต้องการยกเลิก", "ตกลง", {duration: 10000,verticalPosition:"top", horizontalPosition: "center"}); }

        else{
          this.httpClient.delete('http://localhost:8080/cancel/' + this.CancelAppointment.idCardNum + '/'
          + this.CancelAppointment.reason
          ,this.CancelAppointment)
            .subscribe(
               data => {
               console.log(this.CancelAppointment)
                console.log('PUT Request is successful', data);
                this.router.navigate(['/'])
                let snackBarRef = this.snackBar.open('ยกเลิกสำเร็จ!', 'ตกลง',{
                    verticalPosition:"top",
                    horizontalPosition: "center"
                });

               },
               error => {
               console.log('Rrror', error);
                let snackBarRef = this.snackBar.open('ไม่พบข้อมูลการนัดพบ! กรุณาตรวจสอบรหัสบัตรประชาชนให้ถูกต้อง', 'ตกลง',{
                    verticalPosition:"top",
                    horizontalPosition: "center"
                });
               }
            );

          }
      }
}
