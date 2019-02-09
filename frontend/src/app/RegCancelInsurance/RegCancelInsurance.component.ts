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
  save() {
      if(this.cancelInsurances.idCard === '' ||
      this.cancelInsurances.fName === ''||
      this.cancelInsurances.lName === ''  ||
      this.cancelInsurances.eMail === ''  ||
      this.cancelInsurances.tlePhone === ''  ||
      this.cancelInsurances.reasonMemberName === ''){

      alert('กรุณใส่ข้อมูลให้ครบ');

      }else {
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
