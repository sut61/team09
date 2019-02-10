import { Component, OnInit } from '@angular/core';
import { AppointmentService } from '../service/appointment.service';
import { HttpClient } from '@angular/common/http';
import { Router} from '@angular/router';

@Component({
selector: 'app-agent-appointment',
templateUrl: './agent-appointment.component.html',
styleUrls: ['./agent-appointment.component.css']
})
export class AgentAppointmentComponent implements OnInit {
Categories : Array<any>;
Genders: Array<any>;
Date : any = { count: '', status: ''};
Duration : Array<any>;
Provinces : Array<any>;
Appointment : any = {
typeName: '', fName: '', lName: '', idCardNum: '' ,genderName: '', age: '', telNum: ''
,email: '' , provinceName: '', date: '',  duration: ''};

constructor(private appointService : AppointmentService ,private httpClient: HttpClient, private router:Router) { }
  ngOnInit() {
    this.appointService.getAppointment().subscribe(data => { this.Appointment = data; console.log(this.Appointment);});
    this.appointService.getCategory().subscribe(dataF => { this.Categories = dataF; console.log(this.Categories);});
    this.appointService.getGender().subscribe(dataB => { this.Genders = dataB; console.log(this.Genders);});
    this.appointService.getDateAppointment().subscribe(dataC => { this.Date = dataC; console.log(this.Date);});
    this.appointService.getDurationAppointment().subscribe(dataD => { this.Duration = dataD; console.log(this.Duration);});
    this.appointService.getProvince().subscribe(dataE => { this.Provinces = dataE; console.log(this.Provinces);});   }

   save() {
      if(this.Appointment.typeName == null){alert('กรุณาเลือกประเภทประกันที่สนใจ');}

      else if(this.Appointment.fName == null){alert('กรุณากรอกชื่อจริง');}
      else if(this.Appointment.fName.length > 30){ alert('ความยาวชื่อจริงไม่ควรเกิน 30 ตัวอักษร!'); }
      else if(this.Appointment.fName.length < 2){ alert('ความยาวชื่อจริงต้องมากกว่า 2 ตัวอักษร!'); }

      else if(this.Appointment.lName == null){alert('กรุณากรอกนามสกุล');}
      else if(this.Appointment.lName.length > 30){ alert('ความยาวนามสกุลไม่ควรเกิน 30 ตัวอักษร!'); }
      else if(this.Appointment.fName.length < 2){ alert('ความยาวนามสกุลต้องมากกว่า 2 ตัวอักษร!'); }

      else if(this.Appointment.idCardNum == null){alert('กรุณากรอกรหัสบัตรประชาชน');}

      else if(this.Appointment.genderName == null){alert('กรุณาเลือกเพศ');}

      else if(this.Appointment.age == null){alert('กรุณากรอกอายุ');}
      else if(this.Appointment.age < 1 || this.Appointment.age > 80){ alert('อายุไม่อยู่ในช่วงที่กำหนด'); }

      else if(this.Appointment.telNum == null){alert('กรุณากรอกเบอร์โทรศัทพ์');}

      else if(this.Appointment.email == null){alert('กรุณากรอก email');}

      else if(this.Appointment.provinceName == null){alert('กรุณาเลือกจังหวัดที่ต้องการ');}

      else if(this.Appointment.date == null){alert('กรุณาเลือกวันที่ต้องการ');}

      else if(this.Appointment.duration == null){alert('กรุณาเลือกเวลาที่ต้องการ');}


      else{
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
              {alert('ลงทะเบียนสำเร็จ!');}

             },
             error => { console.log('Rrror', error); alert('กรุณาตรวจสอบความถูกต้องของข้อมูล');}
          );

        }
    }
}
