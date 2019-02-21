import { Component, OnInit } from '@angular/core';
import { CancellumpsumService } from '../service/cancellumpsum.service';
import { LumpsumserviceService } from '../service/lumpsumservice.service';
import { HttpClient } from '@angular/common/http';




@Component({
  selector: 'app-cancellumpsum',
templateUrl: './cancellumpsum.component.html',
  styleUrls: ['./cancellumpsum.component.css']
})
export class CancellumpsumComponent implements OnInit {

  Lumpsums : Array<any>;

  displayedColumns: string[] = ['iD','companyName','address','provinceId','zipCode','businessSizeId','establishmentId','categoryId','amoungEmp'];
  Contacts : Array<any>;
  Provinces : Array<any>;
  Cancellumpsum : any = {
  LUMPSUM_ID: '' ,CONTACT_ID: '' , comment: '',PROVINCE_ID: '' ,nameCan: '' , ageCan: '', IDcardCan: ''};

  constructor(private cancellumpsumService : CancellumpsumService ,private httpClient: HttpClient) { }

  ngOnInit() {

    this.cancellumpsumService.getContact().subscribe(dataA => {
    this.Contacts = dataA;
    console.log(this.Contacts);});

    this.cancellumpsumService.getLumpsum().subscribe(dataF => {
    this.Lumpsums = dataF;
    console.log(this.Lumpsums);});

    this.cancellumpsumService.getProvince().subscribe(dataC => {
    this.Provinces = dataC;
    console.log(this.Provinces);});

  }
save() {
      if(this.Cancellumpsum.LUMPSUM_ID === '' || this.Cancellumpsum.CONTACT_ID === ''||
      this.Cancellumpsum.comment === '' || this.Cancellumpsum.PROVINCE_ID === ''
      || this.Cancellumpsum.nameCan === '' || this.Cancellumpsum.ageCan === '' || this.Cancellumpsum.IDcardCan === '' ){
      alert('กรุณใส่ข้อมูลให้ครบ');}

      else if(this.Cancellumpsum.ageCan < 20 || this.Cancellumpsum.ageCan > 80)
      {alert('ต้องมีอายุระหว่าง 20 ถึง 80 ปี');}

      else if(this.Cancellumpsum.nameCan.length > 50)
      {alert('ความยาวชื่อต้องน้อยกว่า50ตัว');}

      else if(/[0-9]{13}/.test(this.Cancellumpsum.IDcardCan) === false)
      {alert('รูปแบบเลขประจำตัวประชาชนไม่ถูกต้อง');}

      else {
        this.httpClient.delete('http://localhost:8080/cancelLumpsum/' + this.Cancellumpsum.LUMPSUM_ID + '/'
        + this.Cancellumpsum.CONTACT_ID + '/'+ this.Cancellumpsum.comment + '/'+ this.Cancellumpsum.PROVINCE_ID
        + '/'+ this.Cancellumpsum.nameCan + '/'+ this.Cancellumpsum.ageCan + '/'+ this.Cancellumpsum.IDcardCan ,
        this.Cancellumpsum)
        .subscribe(
           data => {
              console.log('PUT Request is successful', data);
              alert('ยกเลิกสำเร็จ');
           },
           error => {
              console.log('Rrror', error);
              alert('ข้อมูลไม่ถูกต้อง');
            }
        );

     }
  }

}
