import {HttpClient} from '@angular/common/http';
import {Component,OnInit} from '@angular/core';
import {RegCancelInsuranceService} from  '../service/RegCancelInsurance.Service';


@Component({
  selector: 'app-RegCancelInsurance',
  templateUrl: './RegCancelInsurance.component.html',
  styleUrls: ['./RegCancelInsurance.component.css']
}
)
export class RegCancelInsuranceComponent implements OnInit {
reasonMembers : Array<any>;

cancelInsurances : any = {idCard: '', fName: '', lName: '', eMail: '', tlePhone: '', reasonMemberName: ''};
constructor(private Service : RegCancelInsuranceService ,private httpClient: HttpClient) { }

  ngOnInit() {
    this.Service.getCancelInsurances().subscribe(dataMe => {
                    this.cancelInsurances = dataMe;
                    console.log(this.cancelInsurances);
     });

    this.Service.getReasonMembers().subscribe(dataA => {
                    this.reasonMembers = dataA;
                    console.log(this.reasonMembers);
      });
  }

 /**====SAVE====*/
  save() {
      if(this.cancelInsurances.idCard === '' ||
      this.cancelInsurances.fName === ''||
      this.cancelInsurances.lName === ''  ||
      this.cancelInsurances.eMail === ''  ||
      this.cancelInsurances.tlePhone === ''  ||
      this.cancelInsurances.reasonMemberName === ''){

      alert('กรุณใส่ข้อมูลให้ครบ');
      }
 else if(/[0-9]{13}/.test(this.cancelInsurances.idCard) === false){
          alert('กรอกขรหัสประจำตัวประชาชนให้ถูกต้อง');

      }else if(/^[A-z]*[ก-๐]{2,20}|^[ก-๐]*[A-z]{2,20}/.test(this.cancelInsurances.fName) === false){
          alert('กรอกชื่อให้ถูกต้อง');

      }else if(/^[A-z]*[ก-๐]{2,20}|^[ก-๐]*[A-z]{2,20}/.test(this.cancelInsurances.lName) === false){
          alert('กรอกขนามสกุลให้ถูกต้อง');

      }else if(/[A-Za-z0-9][A-Za-z0-9.]{5}[A-Za-z0-9.]*@[a-z]+.[a-z.]+/.test(this.cancelInsurances.eMail) === false){
          alert('กรอกขอีเมลย์ให้ถูกต้อง');

      }else if(/[0]{1}[6,8,9]{1}[0-9]{8}/.test(this.cancelInsurances.tlePhone) === false ){
          alert('กรอกขเบอร์โทรศัพท์ให้ถูกต้อง');
      }

      else if(this.cancelInsurances.idCard.length < 13){
          alert('รหัสประจำตัวประชาชนสั้นเกินไป ต้องมี 13 ตัว');
      }else if(this.cancelInsurances.fName.length < 2){
          alert('ชื่อสั้นเกินไป ต้องมีอน่างน้อย 2 ตัว');
      }else if(this.cancelInsurances.lName.length < 2){
          alert('นามสกุลสั้นเกินไป ต้องมีอน่างน้อย 2 ตัว');
      }else if(this.cancelInsurances.eMail.length < 4){
          alert('อีเมลย์สั้นเกินไป ต้องมีอน่างน้อย 4 ตัว');
      }else if(this.cancelInsurances.tlePhone.length < 10){
          alert('เบอร์โทรศัพท์ต้องมี 10 ตัว');
      }

      else if(this.cancelInsurances.idCard.length > 13){
          alert('จำนวนรหัสประจำตัวประชาชน ต้องมี 13 ตัว');
      }else if(this.cancelInsurances.fName.length > 20){
          alert('ชื่อยาวเกินไป ต้องไม่เกิน 20');
      }else if(this.cancelInsurances.lName.length > 20){
          alert('นามสกุลยาวเกินไป ต้องไม่เกิน 20 ตัว');
      }else if(this.cancelInsurances.eMail.length > 30){
          alert('อีเมลย์ยาวเกินไป ต้องไม่เกิน30');
      }else if(this.cancelInsurances.tlePhone.length > 10){
          alert('เบอร์โทรศัพท์ต้องมี 10 ตัว');
      }



      else {
        this.httpClient.delete('http://localhost:8080/CancelInsurance/'
        + this.cancelInsurances.idCard + '/'
        + this.cancelInsurances.fName + '/'
        + this.cancelInsurances.lName  + '/'
        + this.cancelInsurances.eMail  + '/'
        + this.cancelInsurances.tlePhone  + '/'
        + this.cancelInsurances.reasonMemberName,
        this.cancelInsurances)
        .subscribe(
           data => {
              console.log(this.cancelInsurances)
              console.log('PUT Request is successful', data);
           },
           error => {
              console.log('Rrror', error); }
        );
     }
  }
}
