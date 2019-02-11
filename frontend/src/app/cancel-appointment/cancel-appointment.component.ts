import { Component, OnInit } from '@angular/core';
import { CancelAppointmentService } from '../service/cancel-appointment.service';
import { AppointmentService } from '../service/appointment.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

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
  ,private httpClient: HttpClient , private router:Router) { }

  ngOnInit() {
    this.cancelService.getCancelAppointment().subscribe(data => { this.CancelAppointment = data; console.log(this.CancelAppointment);});
    this.cancelService.getCancelReason().subscribe(dataB => { this.Reasons = dataB; console.log(this.Reasons);});
    this.appointService.getDateAppointment().subscribe(dataA => { this.Date = dataA; console.log(this.Date);});
  }

  submit(){
       if (this.CancelAppointment.idCardNum == null){alert('กรุณากรอกรหัสบัตรประชาชน');}
       else if(/[0-9]{13}/.test(this.CancelAppointment.idCardNum) === false){ alert('รูปแบบรหัสบัตรประชาชนไม่ถูกต้อง'); }
       else if (this.CancelAppointment.reason == null){alert('กรุณาเลือกเหตุผลที่ต้องการยกเลิก');}

        else{
          this.httpClient.delete('http://localhost:8080/cancel/' + this.CancelAppointment.idCardNum + '/'
          + this.CancelAppointment.reason
          ,this.CancelAppointment)
            .subscribe(
               data => {
               console.log(this.CancelAppointment)
                console.log('PUT Request is successful', data);
                this.router.navigate(['/'])
                {alert('ยกเลิกสำเร็จ!');}
               },
               error => { console.log('Rrror', error); alert('ไม่พบข้อมูลการนัดพบ กรุณาตรวจสอบรหัสบัตรประชาชนให้ถูกต้อง');}
            );

          }
      }
}
